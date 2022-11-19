package pl.dpotyralski;

class PostalCodeResolver {

    public String resolvePostalCode(String street) {

        if (street.equals("Wiejska")) {
            return "00-480";
        }

        if (street.equals("1 sierpnia")) {
            return "02-134";
        }
        if (street.equals("1 Maja")) {
            return "02-495";
        }

        return "not_found";
    }


}
