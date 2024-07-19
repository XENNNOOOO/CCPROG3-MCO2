import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class BookReservationController {
    private BookReservationPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;
    ImageIcon errorImage = new ImageIcon("images/BookingError.png");



    public BookReservationController(BookReservationPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchBookReservationPage(this.mainFrame, this.model.getAllHotelString()); 
        view.addClickListener(new BookReservationListener(this.view, this.model, this.mainFrame)); 
    }

    class BookReservationListener implements ActionListener {
        private BookReservationPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        public BookReservationListener (BookReservationPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int count = 0;
            ImageIcon logoImage = new ImageIcon("images/Check.png");

            String hotelName;
            String guestName;
            int dayIn;
            int dayOut;
            String discCode;
            Hotel hotel = null;
            boolean isSuccess = false;
                
            ErrorPopup ep = new ErrorPopup();

                if (e.getSource() == view.getStnButton()) {
                    hotelName = this.view.getHotelName();
                    guestName = this.view.getGuestName();
                    dayIn = Integer.valueOf(this.view.getDayFromField());
                    dayOut = Integer.valueOf(this.view.getDayToField());
                    discCode = this.view.getCodeField();
                    hotel = this.model.getHotel(hotelName);

                    if (hotel != null) {
                        for (Hotel h : this.model.getHotelList()) {
                            if (h.getName().equals(hotelName)) {
                                break;
                            }
                            count++;
                        }
                    }
                    Room room = this.model.getHotelList().get(count).getStandardRoom(dayIn, dayOut);
                    room.addReservation(guestName, 1299.0, dayIn, dayOut, discCode);

                    for(Reservation r: room.getReservationList()) {
                        if (r.getGuestName().equals(guestName) && r.getCheckIn() == dayIn && r.getCheckOut() == dayOut) {
                            isSuccess = true;
                            break;
                        }
                    }

                    if (isSuccess) {
                        ImageIcon successImg = new ImageIcon("images/BookingSuccess.png");
                        ep.launchErrorPopup(successImg);
                        this.view.getStnButton().setEnabled(false);
                        this.view.getDlxButton().setEnabled(false);
                        this.view.getExcButton().setEnabled(false);
                    }
                    else {
                        ImageIcon errorImg = new ImageIcon("images/BookingError.png");
                        ep.launchErrorPopup(errorImg);
                    }

                } else if (e.getSource() == view.getDlxButton()) {
                    hotelName = this.view.getHotelName();
                    guestName = this.view.getGuestName();
                    dayIn = Integer.valueOf(this.view.getDayFromField());
                    dayOut = Integer.valueOf(this.view.getDayToField());
                    discCode = this.view.getCodeField();
                    hotel = this.model.getHotel(hotelName);

                    if (hotel != null) {
                        for (Hotel h : this.model.getHotelList()) {
                            if (h.getName().equals(hotelName)) {
                                break;
                            }
                            count++;
                        }
                    }
                    Room room = this.model.getHotelList().get(count).getDeluxeRoom(dayIn, dayOut);
                    room.addReservation(guestName, 1299.0, dayIn, dayOut, discCode);

                    for(Reservation r: room.getReservationList()) {
                        if (r.getGuestName().equals(guestName) && r.getCheckIn() == dayIn && r.getCheckOut() == dayOut) {
                            isSuccess = true;
                            break;
                        }
                    }

                    if (isSuccess) {
                        ImageIcon successImg = new ImageIcon("images/BookingSuccess.png");
                        ep.launchErrorPopup(successImg);
                        this.view.getStnButton().setEnabled(false);
                        this.view.getDlxButton().setEnabled(false);
                        this.view.getExcButton().setEnabled(false);
                    }
                    else {
                        ImageIcon errorImg = new ImageIcon("images/BookingError.png");
                        ep.launchErrorPopup(errorImg);
                    }
                } else if (e.getSource() == view.getExcButton()) {
                    hotelName = this.view.getHotelName();
                    guestName = this.view.getGuestName();
                    dayIn = Integer.valueOf(this.view.getDayFromField());
                    dayOut = Integer.valueOf(this.view.getDayToField());
                    discCode = this.view.getCodeField();
                    hotel = this.model.getHotel(hotelName);

                    if (hotel != null) {
                        for (Hotel h : this.model.getHotelList()) {
                            if (h.getName().equals(hotelName)) {
                                break;
                            }
                            count++;
                        }
                    }
                    Room room = this.model.getHotelList().get(count).getExecutiveRoom(dayIn, dayOut);
                    room.addReservation(guestName, 1299.0, dayIn, dayOut, discCode);

                    for(Reservation r: room.getReservationList()) {
                        if (r.getGuestName().equals(guestName) && r.getCheckIn() == dayIn && r.getCheckOut() == dayOut) {
                            isSuccess = true;
                            break;
                        }
                    }

                    if (isSuccess) {
                        ImageIcon successImg = new ImageIcon("images/BookingSuccess.png");
                        ep.launchErrorPopup(successImg);
                        this.view.getStnButton().setEnabled(false);
                        this.view.getDlxButton().setEnabled(false);
                        this.view.getExcButton().setEnabled(false);
                    }
                    else {
                        ImageIcon errorImg = new ImageIcon("images/BookingError.png");
                        ep.launchErrorPopup(errorImg);
                    }
                } else if (e.getSource() == view.getExButton() ) {
                    LaunchPage lp = new LaunchPage();
                    LaunchPageController lpc = new LaunchPageController(lp, this.model, this.mainFrame);
                }
            }
        }
    

}
