package Week7.ManageTheGeographic;

public class Country {

    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public Country() {
    }

    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        if (totalArea > 0) {
            this.totalArea = totalArea;

        } else {
            System.out.println("Total area must be greater than 0.");
        }
    }

    public void display() {
        System.out.println("Country Code: " + countryCode + ", Country Name: " + countryName + ", Total Area: " + totalArea);
    }
}
