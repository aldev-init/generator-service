package aldev.code.tech.service;

import aldev.code.tech.dto.request.SessionExport;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

import java.util.concurrent.ExecutionException;

public interface GeneratorService {

    Response testMethod(String text) throws ExecutionException, InterruptedException;

    Response inquiryActorPaginate(int page, int size);

    Response createSessionExport(String referenceId);

    void consumeSessionExport(SessionExport sessionExport);
}
