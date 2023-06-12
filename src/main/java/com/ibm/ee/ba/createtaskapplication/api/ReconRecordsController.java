package com.ibm.ee.ba.createtaskapplication.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import com.ibm.ee.ba.createtaskapplication.api.model.Response;

@RestController
public class ReconRecordsController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Response response;

    @RequestMapping(value = "/approval/request", method = RequestMethod.POST)
    public Response createProducts(@RequestBody RequestApproval requestApproval) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setBasicAuth("cp4admin", "0ubDqBnAyPEukf0pcuUk");
        System.out.println("before entity");
        HttpEntity<RequestApproval> entity = new HttpEntity<RequestApproval>(requestApproval, headers);
        System.out.println("after entity");
        System.out.println(entity.getBody().toString());

        restTemplate.exchange(
                "https://cpd-cp4ba.cp4ba-automation-685c4d909dba5536870f4da931535b5a-0000.us-south.containers.appdomain.cloud/bas/automationservices/rest/ARA/approvalRequest/approval",
                HttpMethod.POST, entity, String.class).getBody();

        response.setMessage("Reconciliation records has been sent for approval");
        return response;
    }

}
