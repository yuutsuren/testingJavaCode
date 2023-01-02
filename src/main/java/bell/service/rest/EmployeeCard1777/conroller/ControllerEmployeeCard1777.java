package bell.service.rest.EmployeeCard1777.conroller;

import bell.service.rest.EmployeeCard1777.data.WaitTimeEmployeeCard1777;
import bell.service.rest.EmployeeCard1777.template.TemplateEmployeeCard1777;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;


@RestController
public class ControllerEmployeeCard1777 {

    @GetMapping(path = "/api/cross/bscs/v2/by-login/{adLogin}", produces = "application/json;charset=UTF-8")
    public ResponseEntity requestTsesPost(@PathVariable String adLogin, HttpServletResponse response) {

        String message="";

        Date date = new Date();
        System.out.println(date + " EmployeeCard1777 GET "+ adLogin);

        TemplateEmployeeCard1777 objMessage=new TemplateEmployeeCard1777();
        message=objMessage.getStrJson(adLogin);

        try {
            //время задержки ответа
            Thread.sleep(WaitTimeEmployeeCard1777.timeSleepStub);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(date + " EmployeeCard1777 Response: " + message);

        response.addHeader("bscs-response-token","78DF646AA02D486493FBC69C1BBCE4A5");
        response.addHeader("server","nginx");
        response.addHeader("set-cookie","IG_JSESSIONID=27B15B6A227A90CF1BFB1453EEE04B21; Path=/; Secure; HttpOnly");
        response.addHeader("x-ratelimit-limit","-1");
        response.addHeader("end-time","null");
        response.addHeader("jwt","tGzv3JOkF0XG5Qx2TlKWIA");             //random example from web
        response.addHeader("cache-control","private");
        response.addHeader("x-ratelimit-reset","0");
        response.addHeader("x-ratelimit-remaining","0");
        response.addHeader("strict-transport-security","max-age=63072000; includeSubDomains; preload");

        return new ResponseEntity(message, HttpStatus.OK);

    }

    //Установка новой задержек/отклика заглушек
    @GetMapping(value = "/EmployeeCard1777/setTimeSleep/{timeSleep}", produces = "application/json;charset=UTF-8")
    public String setTimeSleep(@PathVariable String timeSleep) {
        WaitTimeEmployeeCard1777.timeSleepStub = Integer.parseInt(timeSleep);
        Date date = new Date();
        System.out.println(date + " Время задержки EmployeeCard1777_mock изменено на " + WaitTimeEmployeeCard1777.timeSleepStub);
        return "ok";
    }

    //Запросили и вывели в логи текущую задержку
    @GetMapping(value = "/EmployeeCard1777/getTimeSleep", produces = "application/json;charset=UTF-8")
    public String getTimeSleep() {
        Date date = new Date();
        System.out.println(date + " Текущее время задержки EmployeeCard1777_mock (ms) " + WaitTimeEmployeeCard1777.timeSleepStub);
        return " Текущее время задержки EmployeeCard1777_mock (ms) " + WaitTimeEmployeeCard1777.timeSleepStub;
    }

}