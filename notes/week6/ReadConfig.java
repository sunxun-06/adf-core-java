import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ReadConfig {
    private static final Logger logger = Logger.getLogger(ReadConfig.class);

    public static void main(String[] args) {
        String path = "C:/Users/35443/Desktop/adf-sample-agent-java/config/module.cfg";
        logger.info("开始读取配置文件: " + path);

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    logger.info("配置项 → " + key + " → 值: " + value);
                    count++;
                } else {
                    logger.warn("跳过无法解析的行: " + line);
                }
            }
            logger.info("配置文件读取完成，共解析 " + count + " 条配置");
        } catch (FileNotFoundException e) {
            logger.error("配置文件不存在: " + path);
        } catch (IOException e) {
            logger.error("读取文件发生IO异常", e);
        }
    }
}