package top.fallenangel;

public class Data {
    private int acc;
    private String city;
    private String dist;
    private String addr;
    private String prov;
    private double lon;
    private String number;
    private String town;
    private String street;
    private double lat;

    public Data() {
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Data{" +
                "acc=" + acc +
                ", city='" + city + '\'' +
                ", dist='" + dist + '\'' +
                ", addr='" + addr + '\'' +
                ", prov='" + prov + '\'' +
                ", lon=" + lon +
                ", number='" + number + '\'' +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", lat=" + lat +
                '}';
    }
}