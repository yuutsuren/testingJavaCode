package bell.service.rest.FLCart1442.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {

    public String getPartyUId(String message){
        String partyUId;

        Pattern pat = Pattern.compile("\"partyUId\":\"(.*?)\"");

        Matcher mat = pat.matcher(message);
        mat.find();
        partyUId= mat.group(1);

        return partyUId;
    }

    public String getRelatedPartyUId(String message){
        String relatedPartyUId;

        Pattern pat = Pattern.compile("\"relatedPartyUId\":\"(.*?)\"");

        Matcher mat = pat.matcher(message);
        mat.find();
        relatedPartyUId= mat.group(1);

        return relatedPartyUId;
    }

}
