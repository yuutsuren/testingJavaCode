package bell.service.rest.SHK1403.template;

public class TemplateSHK1403 {

    public String getStrJson(String uuid) {

        String strJson = "{\"uuid\":\""+uuid+"\",\"name\":\"тигренок.jpg\",\"sourceService\":\"sa_test_mprs@test.vtb.ru\",\"ownerService\":\"sa_test_arrt@test.vtb.ru\",\"bucket\":\"main\",\"folder\":\"arrt\",\"folderOwner\":\"sa_test_mprs@test.vtb.ru\",\"folderUuid\":\"43a925e8-3d4b-42bf-a04d-b80b390d6c74\",\"folders\":[{\"name\":\"arrt\",\"uuid\":\"43a925e8-3d4b-42bf-a04d-b80b390d6c74\",\"sourceService\":\"sa_test_mprs@test.vtb.ru\",\"ownerService\":\"sa_test_mprs@test.vtb.ru\"}],\"versions\":[],\"type\":\"application/octet-stream\",\"size\":211436,\"version\":0,\"uploadDate\":\"2022-09-27T06:21:26Z\",\"hashSum\":\"35c808c52d6fd508d95e314f68c1e101170132e00818be752df0d0fcb7c2bf74\",\"_links\":{\"self\":{\"href\":\"https://ts-ecm-mtls.rs1-genr01-tsec-omnitech-oc-psi.apps.rs1-genr01.test.vtb.ru/files-info/"+uuid+"\"}}}";

        return strJson;
    }

}
