package aldev.code.tech.dto.response.kafkadeserializer;

import aldev.code.tech.dto.request.SessionExport;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class SessionExportDeserializer extends ObjectMapperDeserializer<SessionExport> {

    public SessionExportDeserializer(){
        super(SessionExport.class);
    }

}
