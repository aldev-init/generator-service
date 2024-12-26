package aldev.code.tech.dto.request.kafkaserializer;

import aldev.code.tech.dto.request.SessionExport;
import io.quarkus.kafka.client.serialization.ObjectMapperSerializer;

public class SessionExportSerializer extends ObjectMapperSerializer<SessionExport> {

    public SessionExportSerializer(){
        super();
    }

}
