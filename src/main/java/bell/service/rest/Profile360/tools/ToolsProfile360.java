package bell.service.rest.Profile360.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToolsProfile360 {

    public String getMdmIds(String message){
        String mdmIds;

        Pattern pat = Pattern.compile("\"mdmIds\":\\[\"(.*?)\"\\]");

        Matcher mat = pat.matcher(message);
        mat.find();
        mdmIds= mat.group(1);

        return mdmIds;
    }

}
