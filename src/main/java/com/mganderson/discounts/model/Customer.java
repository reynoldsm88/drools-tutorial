package com.mganderson.discounts.model;

public class Customer {

    private String name;
    private String residentState;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getResidentState() {
        return residentState;
    }

    public void setResidentState( String residentState ) {
        this.residentState = residentState;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( name == null ) ? 0 : name.hashCode() );
        result = prime * result + ( ( residentState == null ) ? 0 : residentState.hashCode() );
        return result;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Customer other = (Customer) obj;
        if ( name == null ) {
            if ( other.name != null )
                return false;
        }
        else if ( !name.equals( other.name ) )
            return false;
        if ( residentState == null ) {
            if ( other.residentState != null )
                return false;
        }
        else if ( !residentState.equals( other.residentState ) )
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", residentState=" + residentState + "]";
    }

}
