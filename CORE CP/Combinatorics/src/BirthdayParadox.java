public class BirthdayParadox {
    public static void main(String[] args) {
        // What is the minimum number of people that should be present
        // in a hall so that there's 50% chance that 2 people have the
        // same birthday ?

        // Prob(2 people having same BDay) = p
        // Prob(No 2 people have the same BDay) = (1-p) = x

        // N = 1, x = 100%
        // N = 2, x = 365*364/(365^2) => 99.73%
        // N = 3, x = 99.17%
        //...
        // N = 23, x ~ 50-%
        // => p ~ 50+%

        // for any probability 'p'
        birthdayParadox(0.500 );
        birthdayParadox(1.0);
    }

    public static void birthdayParadox(double p)
    {
        // Corner Case
        if( p == 1.0 )
            System.out.println(366);

        double x = 1.0;
        double days = 365;
        double curr_days = 364;
        int people = 1;
        while( x>(1-p) )
        {
            x *= (curr_days)/days;
            curr_days--;
            people++;
        }

        System.out.println(1-x);
        System.out.println(people);
    }
}
