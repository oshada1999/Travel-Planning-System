package lk.ijse.nextTravelApp.dto;

import lk.ijse.nextTravelApp.embeded.Contact;
import lk.ijse.nextTravelApp.embeded.RoomOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HotelDTO {
    private Integer hotelId;
    private String hotelName;
    private String hotelCategory;
    private String hotelLocation;
    private String hotelGmapLocation;
    private String hotelEmail;
    private Contact hotelContact;
    private String hotelPetAllow;
    private String hotelCancellationCriteria;
    private RoomOption hotelRoomOpt;
    private byte[] hotelImage;

}