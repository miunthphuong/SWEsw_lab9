import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

public class MortgageCalculator {

	private static final int MINIMUM_AGE = 18;
	private static final double PARTNER_INCOME_FACTOR = 0.94;

	private static final double LOW_INCOME_MINIMUM = 2000;
	private static final double MIDDLE_INCOME_MINIMUM = 3000;
	private static final double HIGH_INCOME_MINIMUM = 5000;

	private static final List<String> TECHNOLOGY_PROFESSIONS = Arrays.asList(
			"Developer",
			"Architect",
			"Scrum master"
	);

	private static final List<String> SUPPORT_PROFESSIONS = Arrays.asList(
			"Tester",
			"System Administrator",
			"Technical writer"
	);

	private static final List<String> MANAGEMENT_PROFESSIONS = Arrays.asList(
			"Department head",
			"Professor"
	);

	public double computeMaxMortgage(
			int yearOfBirth,
			int birthMonth,
			int birthDay,
			double monthlyIncome,
			boolean married,
			double monthlyIncomePartner,
			String profession
	) {
		int age = calculateAge(yearOfBirth, birthMonth, birthDay);

		if (isUnderAge(age)) {
			return 0;
		}

		double eligibleMonthlyIncome = calculateEligibleIncome(
				monthlyIncome,
				married,
				monthlyIncomePartner
		);

		return calculateMortgageAmount(eligibleMonthlyIncome, profession);
	}

	private int calculateAge(int yearOfBirth, int birthMonth, int birthDay) {
		LocalDate birthDate = LocalDate.of(yearOfBirth, birthMonth, birthDay);
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	private boolean isUnderAge(int age) {
		return age <= MINIMUM_AGE;
	}

	private double calculateEligibleIncome(
			double monthlyIncome,
			boolean married,
			double monthlyIncomePartner
	) {
		if (!married) {
			return monthlyIncome;
		}

		return monthlyIncome + monthlyIncomePartner * PARTNER_INCOME_FACTOR;
	}

	private double calculateMortgageAmount(double monthlyIncome, String profession) {
		if (isLowIncome(monthlyIncome)) {
			return calculateLowIncomeMortgage(profession);
		}

		if (isMiddleIncome(monthlyIncome)) {
			return calculateMiddleIncomeMortgage(profession);
		}

		if (isHighIncome(monthlyIncome)) {
			return calculateHighIncomeMortgage(profession);
		}

		return 0;
	}

	private boolean isLowIncome(double monthlyIncome) {
		return monthlyIncome >= LOW_INCOME_MINIMUM && monthlyIncome < MIDDLE_INCOME_MINIMUM;
	}

	private boolean isMiddleIncome(double monthlyIncome) {
		return monthlyIncome >= MIDDLE_INCOME_MINIMUM && monthlyIncome < HIGH_INCOME_MINIMUM;
	}

	private boolean isHighIncome(double monthlyIncome) {
		return monthlyIncome >= HIGH_INCOME_MINIMUM;
	}

	private double calculateLowIncomeMortgage(String profession) {
		if (isTechnologyProfession(profession)) {
			return 160000;
		}

		if (isSupportProfession(profession)) {
			return 120000;
		}

		if (isManagementProfession(profession)) {
			return 220000;
		}

		return 0;
	}

	private double calculateMiddleIncomeMortgage(String profession) {
		if (isTechnologyProfession(profession)) {
			return 180000;
		}

		if (isSupportProfession(profession)) {
			return 140000;
		}

		if (isManagementProfession(profession)) {
			return 250000;
		}

		return 0;
	}

	private double calculateHighIncomeMortgage(String profession) {
		if (isTechnologyProfession(profession)) {
			return 220000;
		}

		if (isSupportProfession(profession)) {
			return 160000;
		}

		if (isManagementProfession(profession)) {
			return 280000;
		}

		return 0;
	}

	private boolean isTechnologyProfession(String profession) {
		return TECHNOLOGY_PROFESSIONS.contains(profession);
	}

	private boolean isSupportProfession(String profession) {
		return SUPPORT_PROFESSIONS.contains(profession);
	}

	private boolean isManagementProfession(String profession) {
		return MANAGEMENT_PROFESSIONS.contains(profession);
	}
}