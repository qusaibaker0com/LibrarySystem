
import java.time.LocalDate;

import library.Library;
import person.admin.Admin;
import person.employee.librarian.Librarian;
import person.employee.receptionist.Receptionist;
import person.member.Member;

public class Main {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();

		Admin admin = new Admin("000000000");
		Library lib = new Library(admin);

		Member m1 = new Member("123456789", "Mazen", "Ahmed", "5", "7", "2002", "593333333", "mazen@member.com",
				today.getDayOfMonth() + "", today.getMonthValue() + "", today.getYear() + "");
		Member m2 = new Member("987654321", "Marwa", "Sami", "25", "12", "1996", "598585946", "marwa@member.com",
				today.getDayOfMonth() + "", today.getMonthValue() + "", today.getYear() + "");
		Member m3 = new Member("147852369", "Saher", "Khaled", "11", "2", "2004", "563216547", "saher@member.com",
				today.getDayOfMonth() + "", today.getMonthValue() + "", today.getYear() + "");

		Librarian l1 = new Librarian("585858585", "Kamel", "Hamad", "3", "4", "1983", "0569638547",
				"kamel@librarian.com", today.getDayOfMonth() + "", today.getMonthValue() + "", today.getYear() + "",
				960, null);

		Receptionist r1 = new Receptionist("785412365", "Shams", "Saleem", "18", "8", "1994", "972596325874",
				"shams@receptionist.com", today.getDayOfMonth() + "", today.getMonthValue() + "", today.getYear() + "",
				900, null);
	}

}
