package bell.service.rest.FLDossier1497.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToolsFLDossier1497 {

    public String getRequestId(String message){
        String requestId;

        Pattern pat = Pattern.compile("\"requestId\":\"(.*?)\"");

        Matcher mat = pat.matcher(message);
        mat.find();
        requestId= mat.group(1);

        return requestId;
    }

}
