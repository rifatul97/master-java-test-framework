package Sql;

record Student (int sid, String sname, String major){

    @Override
    public String toString() {
        return String.format("id: %d, name: %s, major: %s", sid, sname, major);
    }

};
