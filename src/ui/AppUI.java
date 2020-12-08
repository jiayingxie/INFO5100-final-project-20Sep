package ui;

import dao.Special;
import dao.Vehicle;
import dao.VehicleModel;
import dto.AbstractPersistent;
import dto.DataPersistence;
import service.IncentiveApi;
import service.IncentiveApiImpl;
import service.InventiveTimeJob;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AppUI extends AppUIAbstract {

//    private IncentiveApi incentiveApi;
    // ??? to be deleted.
    private IncentiveApiImpl incentiveApi;
    private JPanel centerPanel;

    // sub panel group
    private IncentiveUI incentiveUI;
    private InventiveTimeJob timejob;

    public AppUI() {
        incentiveUI = new IncentiveUI();
        timejob = new InventiveTimeJob();
        timejob.addObserver(incentiveUI);
    }

    /**
     * Simulating Case2
     * @return
     */
    @Override
    protected JPanel getCenterPanel() {
        // init panel
        centerPanel = new JPanel(new GridLayout(0, 2));

        AbstractPersistent dao = new DataPersistence();
        List<Vehicle> vehivles = dao.getAllVehicles();

        // add Component to centerPanel
        int count = 0;
//        for (Vehicle vehicle: vehivles) {
//            centerPanel.add(new JLabel("Car " + (++count), JLabel.CENTER));
//            centerPanel.add(new JLabel(vehicle.getVehicleId()));
//
//            if(incentiveApi == null)
//                incentiveApi = new IncentiveApiImpl();
//            VehicleModel vehicleModel = incentiveApi.updateSpecialPrice(vehicle);
//
//            centerPanel.add(new JLabel("Special Price", JLabel.CENTER));
//            centerPanel.add(new JLabel(vehicleModel.getSpecialPrice() + ""));
//            centerPanel.add(new JLabel("", JLabel.CENTER));
//            centerPanel.add(getPopupBtn(vehicleModel.getSpecial()));
//        }

        // ??? to be deleted.
        for (int i = 0; i < vehivles.size(); ++i) {
            Vehicle vehicle = vehivles.get(i);
            centerPanel.add(new JLabel("Car " + (++count), JLabel.CENTER));
            centerPanel.add(new JLabel(vehicle.getVehicleId()));

            if(incentiveApi == null)
                incentiveApi = new IncentiveApiImpl();

            VehicleModel vehicleModel = incentiveApi.updateSpecialPrice(vehicle);
            if (i == 1) {
                vehicleModel = incentiveApi.updateSpecialPrice2(vehicle);
            } else if (i == 2) {
                vehicleModel = incentiveApi.updateSpecialPrice3(vehicle);
            }

            centerPanel.add(new JLabel("Special Price", JLabel.CENTER));
            centerPanel.add(new JLabel(vehicleModel.getSpecialPrice() + ""));
            centerPanel.add(new JLabel("", JLabel.CENTER));
            if (vehicleModel.getSpecial().getEndDate().getTime() > new Date().getTime()) {
                centerPanel.add(getPopupBtn(vehicleModel.getSpecial()));
            }
        }
        return centerPanel;
    }

    /**
     * pop-up incentive details ---Case6
     * @param special
     * @return
     */
    private JButton getPopupBtn(Special special) {
        JButton popBtn = new JButton("Learn About Discount!!!");

        popBtn.addActionListener((ActionEvent e) -> {
            timejob.start(special);
            JOptionPane.showConfirmDialog(centerPanel, incentiveUI, "Incentive details",
                    JOptionPane.CLOSED_OPTION, JOptionPane.PLAIN_MESSAGE);
            timejob.stop();

            if (new Date().getTime() > special.getEndDate().getTime()) {
                popBtn.setVisible(false);
            }
        });

        return popBtn;
    }

}

