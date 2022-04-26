package br.edu.ifpb.foodstore.service.log;

import br.edu.ifpb.foodstore.domain.LogRegister;
import br.edu.ifpb.foodstore.repository.LogRegisterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RequiredArgsConstructor
@Slf4j
public class LogHandler {

    private final LogRegisterRepository logRegisterRepository;

    public enum LogHandlerType { DATABASE, FILE}

    private final LogHandlerType type;

    private static final String LOG_FILE_NAME = "/tmp/log.log";

    public void log(String message) {
        assert type != null: "tipo de log deve ser definido";
        if (type.equals(LogHandlerType.DATABASE)) {
            LogRegister logRegister = new LogRegister();
            logRegister.setMessage(message);
            logRegister.setDate(Calendar.getInstance());
            logRegisterRepository.save(logRegister);
        } else if (type.equals(LogHandlerType.FILE)) {
            try {
                FileWriter fileWriter = new FileWriter(LOG_FILE_NAME, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                printWriter.printf("%s: %s\n", format.format(Calendar.getInstance().getTime()), message);
                printWriter.close();
            } catch (IOException ioException) {
                log.error("Fail to write to log file");
            }
        }
    }


}
