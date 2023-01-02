package bell.service.rest.ProductProfile1503.conroller;

import bell.service.rest.ProductProfile1503.data.WaitTimeProductProfile1503;
import bell.service.rest.ProductProfile1503.template.TemplatePostProductProfile1503;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.Date;

@RestController
public class ControllerProductProfile1503 {

    @PostMapping(path = "/portfolio/active", produces = "application/json;charset=UTF-8")
    public ResponseEntity requestTsesPost(HttpServletRequest request, HttpServletResponse response) {

        String message="";

        String x_mdm_id="";
        String x_initiator_service="";

        x_mdm_id=request.getHeader("X-MDM-ID");
        x_initiator_service=request.getHeader("X-Initiator-Service");

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line).append(System.lineSeparator());

        } catch (Exception e) { /*report an error*/ }

        Date date = new Date();
        System.out.println(date + " ProductProfile1503 Request Body: " + jb);

        TemplatePostProductProfile1503 objMessage=new TemplatePostProductProfile1503();
        message=objMessage.getStrJson(x_mdm_id);

        try {
            //время задержки ответа
            Thread.sleep(WaitTimeProductProfile1503.timeSleepStub);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(date + " ProductProfile1503 Response: " + message);

        response.addHeader("x-initiator-service",x_initiator_service);
        response.addHeader("set-cookie","73245083a61394aa8fab564a7f5d670f=b0fd447547fb149faac9bc218cba33b5; path=/; HttpOnly; Secure; SameSite=None");
        response.addHeader("x-message-id","3b76ded1-e55d-485a-b383-46bb54b06254");
        response.addHeader("x-call-id","3b76ded1-e55d-485a-b383-46bb54b06254");
        response.addHeader("x-mdm-id",x_mdm_id);

        return new ResponseEntity(message, HttpStatus.OK);

    }

    //Установка новой задержек/отклика заглушек
    @GetMapping(value = "/ProductProfile1503/setTimeSleep/{timeSleep}", produces = "application/json;charset=UTF-8")
    public String setTimeSleep(@PathVariable String timeSleep) {
        WaitTimeProductProfile1503.timeSleepStub = Integer.parseInt(timeSleep);
        Date date = new Date();
        System.out.println(date + " Время задержки ProductProfile1503_mock изменено на " + WaitTimeProductProfile1503.timeSleepStub);
        return "ok";
    }

    //Запросили и вывели в логи текущую задержку
    @GetMapping(value = "/ProductProfile1503/getTimeSleep", produces = "application/json;charset=UTF-8")
    public String getTimeSleep() {
        Date date = new Date();
        System.out.println(date + " Текущее время задержки ProductProfile1503_mock " + WaitTimeProductProfile1503.timeSleepStub);
        return " Текущее время задержки ProductProfile1503_mock (ms) " + WaitTimeProductProfile1503.timeSleepStub;
    }

}