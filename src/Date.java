/**
 * A class representing a date with day, month, and year components.
 */
public class Date {
    protected int day, month, year;

    /**
     * Constructs a date with the specified year, month, and day.
     * If the provided values are invalid, default values are used (1/1/0).
     *
     * @param year the year component of the date
     * @param month the month component of the date
     * @param day the day component of the date
     */
    public Date(int year, int month, int day) {
        if(day<=0 || day>31){
            this.day = 1;
        }else{
            this.day = day;
        }
        if(month<=0 || month > 12){
            this.month = 1;
        }else{
            this.month = month;
        }
        if(year < -3999 || year > 3999){
            this.year = 0;
        }else{
            this.year = year;
        }
    }

    /**
     * Sets the month component of the date to the specified value,
     * if it is a valid month value (between 1 and 12 inclusive).
     *
     * @param month the new month value
     */
    public void setMonth(int month) {
        if(!(month<=0 || month > 12)){
            this.month = month;
        }
    }

    /**
     * Checks if the current date is equal to the specified object.
     * Two dates are considered equal if their day, month, and year components are equal.
     *
     * @param other the object to compare
     * @return true if the dates are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if(other == null) {
            return false;
        }
        if(!(this.hashCode() == other.hashCode()) || !(other instanceof Date)) { // בעיה מבחינת אם איכשהו אותו מס' גיבוב
            return false;
        }
        Date otherDate = (Date) other;
        return (day == otherDate.day) && (month == otherDate.month) && (year == otherDate.year);
    }

    /**
     * Generates a hash code for the current date object.
     * The hash code is calculated using the day, month, and year components.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() { //The use of multiplication and addition operations to combine the hash codes,
                           // for producing a distribution of hash values.
        return 31 * (day + 1) + 11 * (month + 1) + 3997 * (year + 1);
    }

    /**
     * Returns a string representation of the date in the format "DD/MM/YYYY".
     *
     * @return the string representation of the date
     */
    @Override
    public String toString() {
        int DD = this.day;
        int MM = this.month;
        int YYYY = this.year;
        String strDD, strMM, strYYYY;
        if(DD < 10) {
            strDD = "0" + DD;
        } else {
            strDD = String.valueOf(DD);
        }
        if(MM < 10) {
            strMM = "0" + MM;
        } else {
            strMM = String.valueOf(MM);
        }
        if(YYYY > -1) {
            if(YYYY < 10) {
                strYYYY = "000" + YYYY;
            } else if(YYYY < 100) {
                strYYYY = "00" + YYYY;
            } else if(YYYY < 1000) {
                strYYYY = "0" + YYYY;
            } else {
                strYYYY = String.valueOf(YYYY);
            }
        } else {
            YYYY *= (-1);
            if(YYYY < 10) {
                strYYYY = "-000" + YYYY;
            } else if(YYYY < 100) {
                strYYYY = "-00" + YYYY;
            } else if(YYYY < 1000) {
                strYYYY = "-0" + YYYY;
            } else {
                strYYYY = String.valueOf(YYYY);
            }
        }

        return strDD + "/" + strMM + "/" + strYYYY ;
    }
}
