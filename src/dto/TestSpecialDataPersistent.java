package dto;

import dao.Dealer;
import dao.Special;
import dao.Vehicle;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestSpecialDataPersistent {
    public static void main(String[] args) throws Exception {
        DataPersistence dp = new DataPersistence();

        Special i = new Special();
        i.setStartDate(new SimpleDateFormat("dd/MM/yyyy").parse("08/12/2020"));
        i.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2020"));
        i.setDiscountValue(1500);
        //i.setDiscountPercent(0);
        i.setValidOnCashPayment(true);
        i.setValidOnCheckPayment(true);
        i.setValidOnLoan(true);
        i.setValidOnLease(false);
        i.setValueOfVehicle("57000");
        //i.setYear("2017");
        i.setBrand("Cadillac");
        //i.setBodyType("Spark");
        //i.setIsNew("New");
        //i.setScopeMiles("5000");
        i.setTitle("Deals on Cadillac");
        i.setDescription("All Cadillac above $57k on sale with $1500 off.");
        i.setDisclaimer("The vehicle photo displayed may be an example only. Pricing throughout the web site " +
                "does not include any options that may have been installed at the dealership. Please see the dealer " +
                "for details. Vehicles may be in transit or currently in production.");

        List<Dealer> allDealers = dp.getAllDealers();
        i.setDealerId(allDealers.get(new Random().nextInt(allDealers.size())).getDealerId());

        List<Vehicle> allVehicles = dp.getAllVehicles();
        List<String> scopes = new ArrayList<>();
        for (Vehicle v : allVehicles) {
            scopes.add(v.getVehicleId());
        }
        //i.setScope(scopes);

        //dp.writeSpecial(i, i.getDealerId());

        List<Special> allSpecialsRead = dp.getAllSpecials("a199e835-4514-43c3-9ba9-c028e61bb81a");
        for (Special s: allSpecialsRead) {
            System.out.println(s.getSpecialId());
        }
//        System.out.println(allSpecialsRead.get(0).getTitle());
//        System.out.println(allSpecialsRead.get(1).getTitle());
//        System.out.println(allSpecialsRead.get(2).getTitle());

    }
    /*
    f1f55b40-8be1-45b0-a031-f5b777239d79,gmps-brown-wood,null,null,null,null,98121
05dced9f-78fe-492f-8cef-95c71966bd83,gmps-priority,null,null,null,null,98109
15d40b55-3c9f-48b3-a2f7-626a16eef9a0,gmps-goldstein,null,null,null,null,98115
a1248b5a-c785-4fab-9ca7-4e9deb956e9f,gmps-bertogden-cch,null,null,null,null,98115
bc9b02dd-0213-422e-ad55-970b2daa12ad,gmps-chaparral,null,null,null,null,98109
a1888052-0c3e-496c-b8a1-ec22ac73c7b5,gmps-tincher-london,null,null,null,null,98198
676e9bf7-c962-468a-a9ab-9d31b8ec393b,gmps-covert-country,null,null,null,null,98115
515e1a3d-1d73-4b89-ad87-a63f1f5d7677,gmps-mcgee,null,null,null,null,98109
73cf7dfe-b2e1-41be-a4c0-67854ef99b64,gmps-s-jchevrolet,null,null,null,null,98121
1f3f02f6-1d69-4874-b976-e45d0d44a5bc,gmps-aj-dohmann,null,null,null,null,98115
3e5921a5-78ef-44fa-b87b-41e874a7aec6,gmps-curry,null,null,null,null,98001
7ec3dfe4-c831-4675-9859-ce3501fed12c,gmps-shaheen,null,null,null,null,98198
f5e85cfd-8061-4654-a7b9-880368d7eb65,gmps-blue-ribbon,null,null,null,null,98115
18976a19-ef2b-4b7f-b2eb-41fe405076b5,gmps-davis-chevrolet,null,null,null,null,98198
c6733726-84e8-4f7a-a836-bfe7deb17a4a,gmps-mckenna,null,null,null,null,98121
fe9853c6-ad1e-43ed-8160-9b430b0481bd,gmps-roberts-tn,null,null,null,null,98115
635cd070-d029-4c28-838f-8f5a159b6212,gmps-bresee,null,null,null,null,98109
9eaf5f63-03b5-4107-b8cf-f732b16a74de,gmps-carstens-alturas,null,null,null,null,98001
91c12517-8304-4f86-913f-1627d70cdbf8,gmps-mceleney-clinton,null,null,null,null,98109
0c6f8707-bc94-495f-8967-0ff391abc813,gmps-serpentini-orrville,null,null,null,null,98115
a199e835-4514-43c3-9ba9-c028e61bb81a,gmps-peach,null,null,null,null,98198
bae705d7-20da-4ee2-871f-345b2271992b,gmps-ernievon,null,null,null,null,98115
737ac595-0845-4bed-bde2-e730be5de913,gmps-jimmy,null,null,null,null,98109
65fd041d-7952-4e82-a352-2d03a8595c95,gmps-gray-stroudsburg,null,null,null,null,98198
dc54e11d-3aa4-454c-8a7b-bf0f959c9552,gmps-camino,null,null,null,null,98001
d70c2228-9639-4b67-8d0a-86aee1af8ef1,gmps-gilroy,null,null,null,null,98198
f1f55b40-8be1-45b0-a031-f5b777239d79,gmps-brown-wood,null,null,null,null,98121
05dced9f-78fe-492f-8cef-95c71966bd83,gmps-priority,null,null,null,null,98109
15d40b55-3c9f-48b3-a2f7-626a16eef9a0,gmps-goldstein,null,null,null,null,98115
a1248b5a-c785-4fab-9ca7-4e9deb956e9f,gmps-bertogden-cch,null,null,null,null,98115
bc9b02dd-0213-422e-ad55-970b2daa12ad,gmps-chaparral,null,null,null,null,98109
a1888052-0c3e-496c-b8a1-ec22ac73c7b5,gmps-tincher-london,null,null,null,null,98198
676e9bf7-c962-468a-a9ab-9d31b8ec393b,gmps-covert-country,null,null,null,null,98115
515e1a3d-1d73-4b89-ad87-a63f1f5d7677,gmps-mcgee,null,null,null,null,98109
73cf7dfe-b2e1-41be-a4c0-67854ef99b64,gmps-s-jchevrolet,null,null,null,null,98121
1f3f02f6-1d69-4874-b976-e45d0d44a5bc,gmps-aj-dohmann,null,null,null,null,98115
3e5921a5-78ef-44fa-b87b-41e874a7aec6,gmps-curry,null,null,null,null,98001
7ec3dfe4-c831-4675-9859-ce3501fed12c,gmps-shaheen,null,null,null,null,98198
f5e85cfd-8061-4654-a7b9-880368d7eb65,gmps-blue-ribbon,null,null,null,null,98115
18976a19-ef2b-4b7f-b2eb-41fe405076b5,gmps-davis-chevrolet,null,null,null,null,98198
c6733726-84e8-4f7a-a836-bfe7deb17a4a,gmps-mckenna,null,null,null,null,98121
fe9853c6-ad1e-43ed-8160-9b430b0481bd,gmps-roberts-tn,null,null,null,null,98115
635cd070-d029-4c28-838f-8f5a159b6212,gmps-bresee,null,null,null,null,98109
9eaf5f63-03b5-4107-b8cf-f732b16a74de,gmps-carstens-alturas,null,null,null,null,98001
91c12517-8304-4f86-913f-1627d70cdbf8,gmps-mceleney-clinton,null,null,null,null,98109
0c6f8707-bc94-495f-8967-0ff391abc813,gmps-serpentini-orrville,null,null,null,null,98115
a199e835-4514-43c3-9ba9-c028e61bb81a,gmps-peach,null,null,null,null,98198
bae705d7-20da-4ee2-871f-345b2271992b,gmps-ernievon,null,null,null,null,98115
737ac595-0845-4bed-bde2-e730be5de913,gmps-jimmy,null,null,null,null,98109
65fd041d-7952-4e82-a352-2d03a8595c95,gmps-gray-stroudsburg,null,null,null,null,98198
dc54e11d-3aa4-454c-8a7b-bf0f959c9552,gmps-camino,null,null,null,null,98001
d70c2228-9639-4b67-8d0a-86aee1af8ef1,gmps-gilroy,null,null,null,null,98198
f1f55b40-8be1-45b0-a031-f5b777239d79,gmps-brown-wood,null,null,null,null,98121
05dced9f-78fe-492f-8cef-95c71966bd83,gmps-priority,null,null,null,null,98109
15d40b55-3c9f-48b3-a2f7-626a16eef9a0,gmps-goldstein,null,null,null,null,98115
a1248b5a-c785-4fab-9ca7-4e9deb956e9f,gmps-bertogden-cch,null,null,null,null,98115
bc9b02dd-0213-422e-ad55-970b2daa12ad,gmps-chaparral,null,null,null,null,98109
a1888052-0c3e-496c-b8a1-ec22ac73c7b5,gmps-tincher-london,null,null,null,null,98198
676e9bf7-c962-468a-a9ab-9d31b8ec393b,gmps-covert-country,null,null,null,null,98115
515e1a3d-1d73-4b89-ad87-a63f1f5d7677,gmps-mcgee,null,null,null,null,98109
73cf7dfe-b2e1-41be-a4c0-67854ef99b64,gmps-s-jchevrolet,null,null,null,null,98121
1f3f02f6-1d69-4874-b976-e45d0d44a5bc,gmps-aj-dohmann,null,null,null,null,98115
3e5921a5-78ef-44fa-b87b-41e874a7aec6,gmps-curry,null,null,null,null,98001
7ec3dfe4-c831-4675-9859-ce3501fed12c,gmps-shaheen,null,null,null,null,98198
f5e85cfd-8061-4654-a7b9-880368d7eb65,gmps-blue-ribbon,null,null,null,null,98115
18976a19-ef2b-4b7f-b2eb-41fe405076b5,gmps-davis-chevrolet,null,null,null,null,98198
c6733726-84e8-4f7a-a836-bfe7deb17a4a,gmps-mckenna,null,null,null,null,98121
fe9853c6-ad1e-43ed-8160-9b430b0481bd,gmps-roberts-tn,null,null,null,null,98115
635cd070-d029-4c28-838f-8f5a159b6212,gmps-bresee,null,null,null,null,98109
9eaf5f63-03b5-4107-b8cf-f732b16a74de,gmps-carstens-alturas,null,null,null,null,98001
91c12517-8304-4f86-913f-1627d70cdbf8,gmps-mceleney-clinton,null,null,null,null,98109
0c6f8707-bc94-495f-8967-0ff391abc813,gmps-serpentini-orrville,null,null,null,null,98115
a199e835-4514-43c3-9ba9-c028e61bb81a,gmps-peach,null,null,null,null,98198
bae705d7-20da-4ee2-871f-345b2271992b,gmps-ernievon,null,null,null,null,98115
737ac595-0845-4bed-bde2-e730be5de913,gmps-jimmy,null,null,null,null,98109
65fd041d-7952-4e82-a352-2d03a8595c95,gmps-gray-stroudsburg,null,null,null,null,98198
dc54e11d-3aa4-454c-8a7b-bf0f959c9552,gmps-camino,null,null,null,null,98001
d70c2228-9639-4b67-8d0a-86aee1af8ef1,gmps-gilroy,null,null,null,null,98198
f1f55b40-8be1-45b0-a031-f5b777239d79,gmps-brown-wood,null,null,null,null,98121
05dced9f-78fe-492f-8cef-95c71966bd83,gmps-priority,null,null,null,null,98109
15d40b55-3c9f-48b3-a2f7-626a16eef9a0,gmps-goldstein,null,null,null,null,98115
a1248b5a-c785-4fab-9ca7-4e9deb956e9f,gmps-bertogden-cch,null,null,null,null,98115
bc9b02dd-0213-422e-ad55-970b2daa12ad,gmps-chaparral,null,null,null,null,98109
a1888052-0c3e-496c-b8a1-ec22ac73c7b5,gmps-tincher-london,null,null,null,null,98198
676e9bf7-c962-468a-a9ab-9d31b8ec393b,gmps-covert-country,null,null,null,null,98115
515e1a3d-1d73-4b89-ad87-a63f1f5d7677,gmps-mcgee,null,null,null,null,98109
73cf7dfe-b2e1-41be-a4c0-67854ef99b64,gmps-s-jchevrolet,null,null,null,null,98121
1f3f02f6-1d69-4874-b976-e45d0d44a5bc,gmps-aj-dohmann,null,null,null,null,98115
3e5921a5-78ef-44fa-b87b-41e874a7aec6,gmps-curry,null,null,null,null,98001
7ec3dfe4-c831-4675-9859-ce3501fed12c,gmps-shaheen,null,null,null,null,98198
f5e85cfd-8061-4654-a7b9-880368d7eb65,gmps-blue-ribbon,null,null,null,null,98115
18976a19-ef2b-4b7f-b2eb-41fe405076b5,gmps-davis-chevrolet,null,null,null,null,98198
c6733726-84e8-4f7a-a836-bfe7deb17a4a,gmps-mckenna,null,null,null,null,98121
fe9853c6-ad1e-43ed-8160-9b430b0481bd,gmps-roberts-tn,null,null,null,null,98115
635cd070-d029-4c28-838f-8f5a159b6212,gmps-bresee,null,null,null,null,98109
9eaf5f63-03b5-4107-b8cf-f732b16a74de,gmps-carstens-alturas,null,null,null,null,98001
91c12517-8304-4f86-913f-1627d70cdbf8,gmps-mceleney-clinton,null,null,null,null,98109
0c6f8707-bc94-495f-8967-0ff391abc813,gmps-serpentini-orrville,null,null,null,null,98115
     */
}
