package rr.msvehicle;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
  class Vehicleservice {

   // @Autowired
  //  RestTemplate restTemplate;

  //  @Autowired
  //  private LoadBalancerClient balancer;
   @Autowired
   private Remotecall remoteservice;

   @Autowired
   private RemoteCallPos remotecallpos;

    @HystrixCommand(fallbackMethod = "handleservice")
    public String getvehcicledetails(){

     /*   HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers); */
    //    ServiceInstance service = balancer.choose("fleetman-tracker");
    /*    if ( service == null){
            throw new RuntimeException("Postion tracker crashed");
            //  List<ServiceInstance> instances = discoveryservice.getInstances("fleetman-tracker");
            // ServiceInstance service = instances.get(0);
        } */

      //  int port = service.getPort();
        //later replaced by feign client
  //      String physicaladdress = service.getUri().toString();
        //String vehicletracked = restTemplate.exchange(physicaladdress + "/position/fetch/vehicle", HttpMethod.GET, entity, String.class).getBody();
        String vehicletracked = remoteservice.getlatestvehicledetail();

        return vehicletracked;
    }

    public String handleservice(){
        return "No Vehicle Tracked handled with histrix fallback method";
    }

    @HystrixCommand(fallbackMethod = "handleservicepos")
    public Position getvehiclepos(){

        Position postioncoordinates = remotecallpos.getlatestvehicleposition();
        return postioncoordinates;

    }

      public Position handleservicepos(){
          return new Position(BigDecimal.valueOf(1.5),BigDecimal.valueOf(1.5));
      }











}
