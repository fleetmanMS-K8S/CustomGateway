package rr.msvehicle;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="fleetman-vehicle", url="http://minivehicle:8080")
public interface Remotecall {

        @RequestMapping(method= RequestMethod.GET, value="/vehicle/fetch")
        public String getlatestvehicledetail();
}
