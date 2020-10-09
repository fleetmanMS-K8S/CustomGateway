package rr.msvehicle;

import java.math.BigDecimal;

public class Position {

    private BigDecimal lat;
    private BigDecimal longitude;


    public Position(BigDecimal lat,BigDecimal longitude){
        this.lat=lat;
        this.longitude=longitude;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }
}
