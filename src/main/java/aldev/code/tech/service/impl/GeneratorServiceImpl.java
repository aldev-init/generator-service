package aldev.code.tech.service.impl;

import aldev.code.tech.dto.request.SessionExport;
import aldev.code.tech.dto.request.kafkaserializer.SessionExportSerializer;
import aldev.code.tech.dto.response.BaseResponsePaginate;
import aldev.code.tech.model.Actor;
import aldev.code.tech.repository.ActorRepository;
import aldev.code.tech.service.GeneratorService;
import io.smallrye.common.annotation.Blocking;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@ApplicationScoped
public class GeneratorServiceImpl implements GeneratorService {

    @Inject
    ActorRepository actorRepository;

    @Inject
    @Channel("session-export")
    Emitter<SessionExport> emitSessionExport;


    private Logger log = Logger.getLogger(GeneratorServiceImpl.class);

    @Override
    public Response testMethod(String text) throws ExecutionException, InterruptedException {

        CompletableFuture<String> myName = CompletableFuture.supplyAsync(() -> text);

        CompletableFuture<Integer> length = myName.thenApply(value ->{
            log.info("Calculating length");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            log.info(value);
            return value.length();
        });


        return Response.ok().build();
    }

    @Override
    public Response inquiryActorPaginate(int page, int size) {
        long totalData = actorRepository.findAll().count();
        List<Actor> data = actorRepository.findAllPaginate(page, size);
        return Response.ok(new BaseResponsePaginate<Actor>("2000","success",data,page,size,totalData)).build();
    }

    @Override
    public Response createSessionExport(String referenceId) {

        SessionExport sessionExport = new SessionExport();

        sessionExport.setActionName("EXPORT_AGENT");
        sessionExport.setTransactionId(UUID.randomUUID().toString());
        sessionExport.setReferenceId(referenceId);

        try{
            emitSessionExport.send(sessionExport);
        }catch (Exception e){
            log.info("Submit Session Have A Problem: "+e.getMessage());
        }

        return Response.ok().build();
    }

    @Override
    @Incoming("session-export-consumer")
    @Blocking
    public void consumeSessionExport(SessionExport sessionExport) {
        try{
            Thread.sleep(10000);

            log.info("Done Processing for referenceId: "+sessionExport.getReferenceId());
        }catch (Exception e){
            log.info("Processing export have a problem: "+e.getMessage());
        }

    }

}
