package pl.wit.lab2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

/**
 * 
 * @author Maciej Wojdyna
 *
 */
public class Presentation {
    
    // imię
    private String firstName;
    // nazwisko
    private String lastName;
    // dzień, miesiąc urodzenia
    private byte birthdayDay, birthdayMonth;
    // rok urodzenia
    private short birthdayYear;
    // miejsce urodzenia
    private String placeOfBirth;
    // liczba znajomych na fb
    private short facebookFriendsQuantity;
    // odwiedzane miejsca
    private String visitedPlaces[];

    private Presentation(String firstName, String lastName) {
        // inicjalizacja imienia i nazwiska
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Presentation(String firstName, String lastName, byte birthdayDay, byte birthdayMonth, short birthdayYear) {
        // wywołanie konstruktora 2-argumentowego
        this(firstName, lastName);
        // dalsza inicjalizacja
        this.birthdayDay = birthdayDay;
        this.birthdayMonth = birthdayMonth;
        this.birthdayYear = birthdayYear;
        this.visitedPlaces = new String[0];
    }

    public String getFullName() {
        return firstName.concat(" ").concat(lastName);
    }

    public String getBirthdayDateAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append(birthdayDay < 10 ? "0" : "").append(birthdayDay).append(".");
        sb.append(birthdayMonth < 10 ? "0" : "").append(birthdayMonth).append(".");
        sb.append(birthdayYear);
        return sb.toString();
    }


    public byte getAge() {
        LocalDate birthDate = LocalDate.of(birthdayYear, birthdayMonth, birthdayDay);
        return (byte) Period.between(birthDate, LocalDate.now()).getYears();
    }
    

    public void addNewPlace(String place) {
        
        visitedPlaces = Arrays.copyOf(visitedPlaces, visitedPlaces.length + 1);

        visitedPlaces[visitedPlaces.length - 1] = place;
    }


    public String getPresentationStory() {

        StringBuilder story = new StringBuilder();
        
        story.append(getFullName()).append(" ");
        
        story.append("urodził(a) się ");
        if (placeOfBirth != null) {
            story.append("w mieście ").append(placeOfBirth).append(" ");
        } else {
            story.append("w nieznanym miejscu ");
        }
        
        story.append("i ukończył(a) ").append(getAge()).append(" lat(a). ");
        
        story.append("Ma ");
        switch (facebookFriendsQuantity) {
            case 0:
                story.append("zero znajomych na Facebooku.");
                break;
            case 1:
                story.append("jednego znajomego na Facebooku.");
                break;
            case 2:
                story.append("dwóch znajomych na Facebooku.");
                break;
            case 3:
                story.append("trzech znajomych na Facebooku.");
                break;
            default:
                if (facebookFriendsQuantity < 100) {
                    story.append("kilku znajomych na Facebooku.");
                } else if (facebookFriendsQuantity < 1000) {
                    story.append("wielu znajomych na Facebooku.");
                } else {
                    story.append("bardzo wielu znajomych na Facebooku.");
                }
                break;
        }

        if (visitedPlaces.length > 0) {
            story.append(" Odwiedził(a) takie miejsca jak ");
            for (int i = 0; i < visitedPlaces.length; i++) {
                if (i > 0) {
                    story.append(i == visitedPlaces.length - 1 ? " i " : ", ");
                }
                story.append(visitedPlaces[i]);
            }
            story.append(".");
        } else {
            story.append("Nie odwiedził(a) żadnych miejsc.");
        }

        return story.toString();
    }


    ////////////////////////////////////////////
    // Gettery i settery
    ////////////////////////////////////////////

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public short getFacebookFriendsQuantity() {
        return facebookFriendsQuantity;
    }

    public void setFacebookFriendsQuantity(short facebookFriendsQuantity) {
        this.facebookFriendsQuantity = facebookFriendsQuantity;
    }

    public String[] getVisitedPlaces() {
        return visitedPlaces;
    }

    public void setVisitedPlaces(String[] visitedPlaces) {
        this.visitedPlaces = visitedPlaces;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public byte getBirthdayDay() {
		return birthdayDay;
	}

	public void setBirthdayDay(byte birthdayDay) {
		this.birthdayDay = birthdayDay;
	}

	public byte getBirthdayMonth() {
		return birthdayMonth;
	}

	public void setBirthdayMonth(byte birthdayMonth) {
		this.birthdayMonth = birthdayMonth;
	}

	public short getBirthdayYear() {
		return birthdayYear;
	}

	public void setBirthdayYear(short birthdayYear) {
		this.birthdayYear = birthdayYear;
	}
}
