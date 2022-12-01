package view.GUI;

import controller.BookingResource;
import model.Reservation.Reservation;
import view.GUI.BUILDINGS.Buildings;
import view.GUI.ROOMS.Rooms;
import view.GUI.Reservation.ReservationBID;
import view.GUI.Reservation.ViewResID;
import view.GUI.USER.User;
import view.ViewHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

public class Main_GUI extends JFrame implements Runnable {

    private boolean isGUIView;
    private JButton ADDDELVIEWUsersButton;
    private JButton BUILDINGSButton;
    private JButton RESERVATIONSButton;
    private JPanel main_GUI;
    private JButton VIEWRESERVATIONSBYBOOKINGButton;
    private JButton VIEWBOOKEDROOMSButton;
    private JButton VIEWRESERVATIONSBYEMAILButton;
    private JButton SAVEDATAButton;
    private JButton LOADDATAButton;
    private JButton EXITButton;
    private JButton ROOMSButton1;

    public Main_GUI(BookingResource bookingResource) {
        this.isGUIView = true;
        setContentPane(this.main_GUI);
        setTitle("UNIVERSITY ROOM BOOKING APPLICATION");
        setSize(450, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        ADDDELVIEWUsersButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new User(bookingResource);
            }
        });
        SAVEDATAButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bookingResource.resSave();
                    bookingResource.roomSave();
                    bookingResource.userSave();
                    bookingResource.buildSave();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(main_GUI, "Saved the data Successfully.");
            }
        });
        LOADDATAButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bookingResource.userLoad();
                    bookingResource.buildLoad();
                    bookingResource.roomLoad();
                    bookingResource.resLoad();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(main_GUI, "Loaded the Data Successfully.");
            }
        });
        EXITButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                setGUIView(false);
                if (ViewHandler.isCommandView) {
                    System.exit(0);
                } else {
                    ViewHandler.isGUIView = true;
                    dispose();
                }
                JOptionPane.showMessageDialog(main_GUI, "Exited the application.");
            }

        });

        BUILDINGSButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Buildings(bookingResource);
            }
        });
        ROOMSButton1.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Rooms(bookingResource);
            }
        });
        RESERVATIONSButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new view.GUI.Reservation.Reservation(bookingResource);
            }
        });
        VIEWRESERVATIONSBYBOOKINGButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ReservationBID(bookingResource);
            }
        });
        VIEWBOOKEDROOMSButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Map<String, Reservation> allRooms = bookingResource.bookedRooms();
                    for (Map.Entry<String, Reservation> entry : allRooms.entrySet()) {
                        JOptionPane.showMessageDialog(main_GUI, "Booked Rooms :\n" + "Booking Reference: " + entry.getValue().getBookingID() + "\n" + entry.getValue().getRoom() + " is booked by " + entry.getValue().getEmail() + " from " + entry.getValue().getCheckInDate() + ":" + entry.getValue().getCheckInTime() + " to " + entry.getValue().getCheckOutDate() + ":" + entry.getValue().getCheckOutTime());
                    }
                } catch (IllegalArgumentException ex) {
                    String error = ex.getLocalizedMessage();
                    JOptionPane.showMessageDialog(main_GUI, error);
                }
            }
        });
        VIEWRESERVATIONSBYEMAILButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewResID(bookingResource);
                try {

                } catch (IllegalArgumentException ex) {
                    String error = ex.getLocalizedMessage();
                    JOptionPane.showMessageDialog(main_GUI, error);
                }
            }
        });
    }

    public boolean isGUIView() {
        return isGUIView;
    }

    public void setGUIView(boolean GUIView) {
        isGUIView = GUIView;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        main_GUI = new JPanel();
        main_GUI.setLayout(new GridBagLayout());
        ADDDELVIEWUsersButton = new JButton();
        ADDDELVIEWUsersButton.setText("USER");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main_GUI.add(ADDDELVIEWUsersButton, gbc);
        BUILDINGSButton = new JButton();
        BUILDINGSButton.setText("BUILDINGS");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main_GUI.add(BUILDINGSButton, gbc);
        RESERVATIONSButton = new JButton();
        RESERVATIONSButton.setText("RESERVATIONS");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main_GUI.add(RESERVATIONSButton, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("University Booking Application");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        main_GUI.add(label1, gbc);
        VIEWRESERVATIONSBYBOOKINGButton = new JButton();
        VIEWRESERVATIONSBYBOOKINGButton.setText("VIEW RESERVATIONS BY BOOKING ID");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main_GUI.add(VIEWRESERVATIONSBYBOOKINGButton, gbc);
        VIEWBOOKEDROOMSButton = new JButton();
        VIEWBOOKEDROOMSButton.setText("VIEW BOOKED ROOMS");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main_GUI.add(VIEWBOOKEDROOMSButton, gbc);
        VIEWRESERVATIONSBYEMAILButton = new JButton();
        VIEWRESERVATIONSBYEMAILButton.setText("VIEW RESERVATIONS BY EMAIL ID");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main_GUI.add(VIEWRESERVATIONSBYEMAILButton, gbc);
        SAVEDATAButton = new JButton();
        SAVEDATAButton.setText("SAVE DATA");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main_GUI.add(SAVEDATAButton, gbc);
        LOADDATAButton = new JButton();
        LOADDATAButton.setText("LOAD DATA");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main_GUI.add(LOADDATAButton, gbc);
        EXITButton = new JButton();
        EXITButton.setText("EXIT");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main_GUI.add(EXITButton, gbc);
        ROOMSButton1 = new JButton();
        ROOMSButton1.setText("ROOMS");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main_GUI.add(ROOMSButton1, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return main_GUI;
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

    }
}
