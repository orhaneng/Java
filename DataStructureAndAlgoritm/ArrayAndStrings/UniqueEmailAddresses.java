import java.util.HashSet;

/*https://leetcode.com/problems/unique-email-addresses/
 * 929. Unique Email Addresses
Easy

373

108

Favorite

Share
Every email consists of a local name and a domain name, separated by the @ sign.

For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

Besides lowercase letters, these emails may contain '.'s or '+'s.

If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)

If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails? 


 */
public class UniqueEmailAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] list = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(list));
		}
	
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> h = new HashSet<String>(); 

        for(int i=0;i<emails.length;i++){
            h.add(clean(emails[i]));
        }
        
        return h.size();
    }
    
    public static String clean(String mail){
        StringBuilder builder = new StringBuilder();
        boolean plusflag=false;
        boolean domainflag=false;
        for(int i=0;i<mail.length();i++){
            if(plusflag&&(!"@".equals(String.valueOf(mail.charAt(i))))){
                continue;
            }
            else if(plusflag && "@".equals(String.valueOf(mail.charAt(i)))){
                builder.append(mail.charAt(i));
                plusflag=false;
                domainflag=true;
                continue;
            }
            if(!domainflag&&".".equals(String.valueOf(mail.charAt(i)))){
                continue;   
            }
            else if("+".equals(String.valueOf(mail.charAt(i)))){
                plusflag=true;
                continue;
            }
            
            builder.append(mail.charAt(i));
        }
        return builder.toString();
    }

}
