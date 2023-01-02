package bell.service.rest.Profile360.template;

public class TemplatePostProfile360 {

    public String getStrJson(String mdmIds) {

        String strJson = "{\"clientProfiles\":[],\"errorList\":[{\"mdmId\":\""+mdmIds+"\",\"code\":\"WA2\",\"message\":\"Client not found\"},{\"code\":\"OK\",\"message\":\"Success\"}]}";

        return strJson;
    }

}
