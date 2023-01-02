package bell.service.rest.Profile360.conroller;

import bell.service.rest.Profile360.data.WaitTimeProfile360;
import bell.service.rest.Profile360.template.TemplatePostProfile360;
import bell.service.rest.Profile360.tools.ToolsProfile360;
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
public class ControllerProfile360 {

    @PostMapping(path = "/api/rb/aprf/client/v1/getProfile", produces = "application/json;charset=UTF-8")
    public ResponseEntity requestTsesPost(HttpServletRequest request, HttpServletResponse response) {

        String message="";

        String mdmIds="";
        String x_initiator_service="";

        x_initiator_service=request.getHeader("x-initiator-service");

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line).append(System.lineSeparator());

        } catch (Exception e) { /*report an error*/ }

        Date date = new Date();
        System.out.println(date + " Profile360 Request Body: " + jb);

        ToolsProfile360 objT = new ToolsProfile360();
        mdmIds = objT.getMdmIds(jb.toString());

        TemplatePostProfile360 objMessage=new TemplatePostProfile360();
        message=objMessage.getStrJson(mdmIds);

        try {
            //время задержки ответа
            Thread.sleep(WaitTimeProfile360.timeSleepStub);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(date + " Profile360 Response: " + message);

        response.addHeader("x-initiator-service",x_initiator_service);
        response.addHeader("set-cookie","edfeabe815d992cbe922ab35c056294f=d7949eb6300207fac078f201d5454cf2; path=/; HttpOnly");
        response.addHeader("x-message-id","737e5df9-b9be-4c4f-9f05-12ddd85a8ce6");
        response.addHeader("x-call-id","737e5df9-b9be-4c4f-9f05-12ddd85a8ce6");

        return new ResponseEntity(message, HttpStatus.OK);

    }

    //Установка новой задержек/отклика заглушек
    @GetMapping(value = "/Profile360/setTimeSleep/{timeSleep}", produces = "application/json;charset=UTF-8")
    public String setTimeSleep(@PathVariable String timeSleep) {
        WaitTimeProfile360.timeSleepStub = Integer.parseInt(timeSleep);
        Date date = new Date();
        System.out.println(date + " Время задержки Profile360_mock изменено на " + WaitTimeProfile360.timeSleepStub);
        return "ok";
    }

    //Запросили и вывели в логи текущую задержку
    @GetMapping(value = "/Profile360/getTimeSleep", produces = "application/json;charset=UTF-8")
    public String getTimeSleep() {
        Date date = new Date();
        System.out.println(date + " Текущее время задержки Profile360_mock " + WaitTimeProfile360.timeSleepStub);
        return " Текущее время задержки Profile360_mock (ms) " + WaitTimeProfile360.timeSleepStub;
    }

}