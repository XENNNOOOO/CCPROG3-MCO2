import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Controller class that manages booking reservations based on user actions in the BookReservationPage.
 */
public class BookReservationController {
    private BookReservationPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;
    ImageIcon errorImage = new ImageIcon("images/BookingError.png");

    /**
     * Constructs a new BookReservationController with the specified view, model, and main frame.
     *
     * @param view      The view (BookReservationPage) associated with this controller.
     * @param model     The model (HotelReservationSystemModel) containing hotel and reservation data.
     * @param mainFrame The main JFrame of the application.
     */
    public BookReservationController(BookReservationPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchBookReservationPage(this.mainFrame, this.model.getAllHotelString()); 
        view.addClickListener(new BookReservationListener(this.view, this.model, this.mainFrame)); 
    }

    /**
     * ActionListener implementation that handles user actions (booking) in the BookReservationPage.
     */
    class BookReservationListener implements ActionListener {
        private BookReservationPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        /**
         * Constructs a BookReservationListener with the specified view, model, and main frame.
         *
         * @param view      The view (BookReservationPage) associated with this listener.
         * @param model     The model (HotelReservationSystemModel) containing hotel and reservation data.
         * @param mainFrame The main JFrame of the application.
         */
        public BookReservationListener (BookReservationPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        /**
         * Handles user actions (booking) performed through buttons in the BookReservationPage.
         *
         * @param e The ActionEvent triggered by user interaction with buttons.
         */
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
            boolean hotelExist = false;
                
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
                                hotelExist = true;
                                break;
                            }
                            count++;
                        }
                    }

                    Room room = this.model.getHotelList().get(count).getStandardRoom(dayIn, dayOut);

                    if (dayIn < dayOut && hotelExist == true) {
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
                                hotelExist = true;
                                break;
                            }
                            count++;
                        }
                    }

                    Room room = this.model.getHotelList().get(count).getDeluxeRoom(dayIn, dayOut);

                    if (dayIn < dayOut && hotelExist == true) {
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
                                hotelExist = true;
                                break;
                            }
                            count++;
                        }
                    }

                    Room room = this.model.getHotelList().get(count).getExecutiveRoom(dayIn, dayOut);

                    if (dayIn < dayOut && hotelExist == true) {
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
                    }
                } else if (e.getSource() == view.getExButton() ) {
                    LaunchPage lp = new LaunchPage();
                    LaunchPageController lpc = new LaunchPageController(lp, this.model, this.mainFrame);
                }
            }
        }
    

}
