package rr.msvehicle;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="fleetman-pos", url="http://miniposra:8888")
public interface RemoteCallPos {

    @RequestMapping(method= RequestMethod.GET, value="/position/fetch/village_truck",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE })
    public Position getlatestvehicleposition();
}
