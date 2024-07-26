import java.util.regex.Matcher;
import java.util.regex.Pattern;

//A small, one-file program that demonstrates crafting and usage of Regular Expressions in Java
//Expressions contained within were written manually by the author as an exercise
//The author is aware that there are tools and online resources to create them faster
public class Main
{
	public static void main(String[] args)
	{
		String[] validExamples = {
				"john.boy@valid.com",
				"jane.doe-smith@valid.co.uk",
				"jane_Doe1976@valid.co.uk",
				"bob-1964@valid.net",
				"elaine@valid-test.com.au",
				"david@valid.io"
		};

		String[] invalidExamples = {
				"john.boy@invalid",
				"bob!@invalid.com",
				"elaineinvalid1983@.com",
				"testing@example@invalid.co.uk",
				"david@invalid..com"
		};

		//Here is the desired pattern, explained in plain English:
		//alpha-numeric characters, dashes, dots and underscores only for the username
		//followed by exactly 1 @ symbol
		//subdomain and domain is alpha-numeric characters or dashes, without doubling symbols
		//subdomain is optional, and multiple are allowed
		Pattern emailPattern =
				Pattern.compile("(?<username>[a-z0-9._\\-]+@)(?<subdomain>[a-z0-9\\-]+[.])+(?<domain>[a-z0-9\\-]+)",
				Pattern.CASE_INSENSITIVE);

		System.out.println("Attempting to check valid examples");
		for(String s : validExamples)
		{
			Matcher valid = emailPattern.matcher(s);
			System.out.println(s + ": " + valid.matches());
		}

		//visible line break for clarity when reading the console output
		System.out.println("------------------------");

		System.out.println("Attempting to check known INVALID examples");
		for(String s : invalidExamples)
		{
			Matcher invalid = emailPattern.matcher(s);
			System.out.println(s + ": " + invalid.matches());
		}
	}
}
