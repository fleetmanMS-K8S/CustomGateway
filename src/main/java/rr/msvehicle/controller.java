package rr.msvehicle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/vehicle")
public class controller {

    @Autowired
    Vehicleservice vehicleservice;




    @GetMapping("/fetch")
    public String currenttrackedvehicledetails(){

        String vehicledetails = vehicleservice.getvehcicledetails();
        System.out.println(vehicledetails);
        return vehicledetails;
    }


    @GetMapping("/fetch/position")
    public ResponseEntity currenttrackedvehiclepos(){

        try {
            Position vehiclepos = vehicleservice.getvehiclepos();
         //   System.out.println(vehiclepos);
       //     JSONObject obj = new JSONObject(vehiclepos);
            return ResponseEntity.status(HttpStatus.OK).body(vehiclepos);
        }


        catch(Exception e) {
            System.out.println("Problem with Gateway fetching of Position");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
