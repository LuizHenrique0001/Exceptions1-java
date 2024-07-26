package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkIn = checkin;
        this.checkOut = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkOut;
    }

     public Long duration(){

//     Diferenca De tempo em milisegundos
        long diff = checkOut.getTime() - checkIn.getTime();

//        Converte o valor de milesegundos para dias
         return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
     }

     public String updateDates(Date checkIn, Date checkOut){
         Date now = new Date();
         if(checkIn.before(now)||checkOut.before(now)){
             return " Reservation dates for update must be future dates";
         }
         if(!checkOut.after(checkIn)){
            return " Check-out date must be after check-in date";
         }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
     }

     @Override
    public String toString(){
        return "Room"
                +roomNumber
                +", check-in: "
                + sdf.format(checkIn)
                +", checkout: "
                + sdf.format(checkOut)
                +", "
                +duration()
                +" nights";
     }
}
