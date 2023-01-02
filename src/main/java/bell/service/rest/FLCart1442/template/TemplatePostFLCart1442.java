package bell.service.rest.FLCart1442.template;

public class TemplatePostFLCart1442 {

    public String getStrJson(String partyUId, String relatedPartyUId) {

        String strJson = "{\"messageResponse\":{\"partyLink\":[{\"partyUId\":\""+partyUId+"\",\"relatedPartyUId\":\""+relatedPartyUId+"\"}]}}";

        return strJson;
    }

}
