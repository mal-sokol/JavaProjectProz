package proz;

import proz.database.daos.*;
import proz.database.models.*;
import proz.database.utils.DbManager;
import proz.utils.exceptions.ApplicationException;

import java.util.Date;


public class Data {


    public static void main(String[] args)  throws ApplicationException {

        DbManager.initDatabase();
        CategoryDao categoryDao = new CategoryDao();
        AnswerDao answerDao = new AnswerDao();
        QuestionDao questionDao = new QuestionDao();
        ResultDao resultDao = new ResultDao();
        TestDao testDao = new TestDao();
        UserDao userDao = new UserDao();


        User u1 = new User();
        u1.setUsername("David");
        u1.setPassword("09090");
        u1.setTeacher(false);
        userDao.createOrUpdate(u1);

        User u2 = new User();
        u2.setUsername("Kathrin");
        u2.setPassword("989888");
        u2.setTeacher(false);
        userDao.createOrUpdate(u2);

        User u3 = new User();
        u3.setUsername("Joseph");
        u3.setPassword("87878");
        u3.setTeacher(false);
        userDao.createOrUpdate(u3);

        User u4 = new User();
        u4.setUsername("Luke");
        u4.setPassword("00000");
        u4.setTeacher(false);
        userDao.createOrUpdate(u4);

        User u5 = new User();
        u5.setUsername("Lucy");
        u5.setPassword("0088");
        u5.setTeacher(false);
        userDao.createOrUpdate(u5);


        Category ch = new Category();
        ch.setName("Chemistry");
        categoryDao.createOrUpdate(ch);

        Test chT1 = new Test();
        chT1.setCategoryId(ch);
        chT1.setName("Periodic table of elements");
        testDao.createOrUpdate(chT1);

        Question q1ch1 = new Question();
        q1ch1.setQuestion("Horizontal rows of the periodic table are called :\n");
        q1ch1.setTestId(chT1);
        questionDao.createOrUpdate(q1ch1);
        Answer a1q1ch1 = new Answer();
        Answer a2q1ch1 = new Answer();
        Answer a3q1ch1 = new Answer();
        Answer a4q1ch1 = new Answer();
        a1q1ch1.setCorrect(false);
        a2q1ch1.setCorrect(false);
        a3q1ch1.setCorrect(true);
        a4q1ch1.setCorrect(false);
        a1q1ch1.setQuestionId(q1ch1);
        a2q1ch1.setQuestionId(q1ch1);
        a3q1ch1.setQuestionId(q1ch1);
        a4q1ch1.setQuestionId(q1ch1);
        a1q1ch1.setAnswer("Series");
        a2q1ch1.setAnswer("Groups");
        a3q1ch1.setAnswer("Periods");
        a4q1ch1.setAnswer("Sets");
        answerDao.createOrUpdate(a1q1ch1);
        answerDao.createOrUpdate(a2q1ch1);
        answerDao.createOrUpdate(a3q1ch1);
        answerDao.createOrUpdate(a4q1ch1);

        Question q2ch1 = new Question();
        q2ch1.setQuestion("Columns of the periodic table are called :");
        q2ch1.setTestId(chT1);
        questionDao.createOrUpdate(q2ch1);
        Answer a1q2ch1 = new Answer();
        Answer a2q2ch1 = new Answer();
        Answer a3q2ch1 = new Answer();
        Answer a4q2ch1 = new Answer();
        a1q2ch1.setCorrect(false);
        a2q2ch1.setCorrect(false);
        a3q2ch1.setCorrect(false);
        a4q2ch1.setCorrect(true);
        a1q2ch1.setQuestionId(q2ch1);
        a2q2ch1.setQuestionId(q2ch1);
        a3q2ch1.setQuestionId(q2ch1);
        a4q2ch1.setQuestionId(q2ch1);
        a1q2ch1.setAnswer("Periods");
        a2q2ch1.setAnswer("Series");
        a3q2ch1.setAnswer("Categories");
        a4q2ch1.setAnswer("Groups");
        answerDao.createOrUpdate(a1q2ch1);
        answerDao.createOrUpdate(a2q2ch1);
        answerDao.createOrUpdate(a3q2ch1);
        answerDao.createOrUpdate(a4q2ch1);

        Question q3ch1 = new Question();
        q3ch1.setQuestion("Atoms in the periodic table are arranged from left to right and top to bottom in order of:");
        q3ch1.setTestId(chT1);
        questionDao.createOrUpdate(q3ch1);
        Answer a1q3ch1 = new Answer();
        Answer a2q3ch1 = new Answer();
        Answer a3q3ch1 = new Answer();
        Answer a4q3ch1 = new Answer();
        a1q3ch1.setCorrect(false);
        a2q3ch1.setCorrect(true);
        a3q3ch1.setCorrect(false);
        a4q3ch1.setCorrect(false);
        a1q3ch1.setQuestionId(q3ch1);
        a2q3ch1.setQuestionId(q3ch1);
        a3q3ch1.setQuestionId(q3ch1);
        a4q3ch1.setQuestionId(q3ch1);
        a1q3ch1.setAnswer("decreasing atomic mass");
        a2q3ch1.setAnswer("increasing atomic number");
        a3q3ch1.setAnswer("decreasing reactivity");
        a4q3ch1.setAnswer("alphabetically");
        answerDao.createOrUpdate(a1q3ch1);
        answerDao.createOrUpdate(a2q3ch1);
        answerDao.createOrUpdate(a3q3ch1);
        answerDao.createOrUpdate(a4q3ch1);

        Question q4ch1 = new Question();
        q4ch1.setQuestion("The most reactive metals belong to the group called:");
        q4ch1.setTestId(chT1);
        questionDao.createOrUpdate(q4ch1);
        Answer a1q4ch1 = new Answer();
        Answer a2q4ch1 = new Answer();
        Answer a3q4ch1 = new Answer();
        Answer a4q4ch1 = new Answer();
        a1q4ch1.setCorrect(false);
        a2q4ch1.setCorrect(false);
        a3q4ch1.setCorrect(false);
        a4q4ch1.setCorrect(true);
        a1q4ch1.setQuestionId(q4ch1);
        a2q4ch1.setQuestionId(q4ch1);
        a3q4ch1.setQuestionId(q4ch1);
        a4q4ch1.setQuestionId(q4ch1);
        a1q4ch1.setAnswer("rare-earth metals");
        a2q4ch1.setAnswer("precious metals");
        a3q4ch1.setAnswer("lanthanides");
        a4q4ch1.setAnswer("alkali metals");
        answerDao.createOrUpdate(a1q4ch1);
        answerDao.createOrUpdate(a2q4ch1);
        answerDao.createOrUpdate(a3q4ch1);
        answerDao.createOrUpdate(a4q4ch1);

        Question q5ch1 = new Question();
        q5ch1.setQuestion("Which one does not name one of periodic table blocks?");
        q5ch1.setTestId(chT1);
        questionDao.createOrUpdate(q5ch1);
        Answer a1q5ch1 = new Answer();
        Answer a2q5ch1 = new Answer();
        Answer a3q5ch1 = new Answer();
        Answer a4q5ch1 = new Answer();
        a1q5ch1.setCorrect(false);
        a2q5ch1.setCorrect(false);
        a3q5ch1.setCorrect(true);
        a4q5ch1.setCorrect(false);
        a1q5ch1.setQuestionId(q5ch1);
        a2q5ch1.setQuestionId(q5ch1);
        a3q5ch1.setQuestionId(q5ch1);
        a4q5ch1.setQuestionId(q5ch1);
        a1q5ch1.setAnswer("p-block");
        a2q5ch1.setAnswer("f-block");
        a3q5ch1.setAnswer("t-block");
        a4q5ch1.setAnswer("s-block");
        answerDao.createOrUpdate(a1q5ch1);
        answerDao.createOrUpdate(a2q5ch1);
        answerDao.createOrUpdate(a3q5ch1);
        answerDao.createOrUpdate(a4q5ch1);
        


        Test chT2 = new Test();
        chT2.setCategoryId(ch);
        chT2.setName("Hydrocarbons");
        testDao.createOrUpdate(chT2);

        Question q1ch2 = new Question();
        q1ch2.setQuestion("Which one names two categories we divide all chemical compounds into?");
        q1ch2.setTestId(chT1);
        questionDao.createOrUpdate(q1ch2);
        Answer a1q1ch2 = new Answer();
        Answer a2q1ch2 = new Answer();
        Answer a3q1ch2 = new Answer();
        Answer a4q1ch2 = new Answer();
        a1q1ch2.setCorrect(false);
        a2q1ch2.setCorrect(true);
        a3q1ch2.setCorrect(false);
        a4q1ch2.setCorrect(false);
        a1q1ch2.setQuestionId(q1ch2);
        a2q1ch2.setQuestionId(q1ch2);
        a3q1ch2.setQuestionId(q1ch2);
        a4q1ch2.setQuestionId(q1ch2);
        a1q1ch2.setAnswer("metals and nonmetals");
        a2q1ch2.setAnswer("organic and inorganic");
        a3q1ch2.setAnswer("saturated and unsaturated");
        a4q1ch2.setAnswer("homogeneous and non-homogeneous");
        answerDao.createOrUpdate(a1q1ch2);
        answerDao.createOrUpdate(a2q1ch2);
        answerDao.createOrUpdate(a3q1ch2);
        answerDao.createOrUpdate(a4q1ch2);

        Question q2ch2 = new Question();
        q2ch2.setQuestion("If a saturated hydrocarbon has n carbon atoms, then it must also have:");
        q2ch2.setTestId(chT1);
        questionDao.createOrUpdate(q2ch2);
        Answer a1q2ch2 = new Answer();
        Answer a2q2ch2 = new Answer();
        Answer a3q2ch2 = new Answer();
        Answer a4q2ch2 = new Answer();
        a1q2ch2.setCorrect(false);
        a2q2ch2.setCorrect(false);
        a3q2ch2.setCorrect(true);
        a4q2ch2.setCorrect(false);
        a1q2ch2.setQuestionId(q2ch2);
        a2q2ch2.setQuestionId(q2ch2);
        a3q2ch2.setQuestionId(q2ch2);
        a4q2ch2.setQuestionId(q2ch2);
        a1q2ch2.setAnswer("3n hydrogen atoms");
        a2q2ch2.setAnswer("2n+1 hydrogen atoms");
        a3q2ch2.setAnswer("2n+2 hydrogen atoms");
        a4q2ch2.setAnswer("n+2 hydrogen atoms");
        answerDao.createOrUpdate(a1q2ch2);
        answerDao.createOrUpdate(a2q2ch2);
        answerDao.createOrUpdate(a3q2ch2);
        answerDao.createOrUpdate(a4q2ch2);

        Question q3ch2 = new Question();
        q3ch2.setQuestion("Which one names saturated hydrocarbons?");
        q3ch2.setTestId(chT1);
        questionDao.createOrUpdate(q3ch2);
        Answer a1q3ch2 = new Answer();
        Answer a2q3ch2 = new Answer();
        Answer a3q3ch2 = new Answer();
        Answer a4q3ch2 = new Answer();
        a1q3ch2.setCorrect(true);
        a2q3ch2.setCorrect(false);
        a3q3ch2.setCorrect(false);
        a4q3ch2.setCorrect(false);
        a1q3ch2.setQuestionId(q3ch2);
        a2q3ch2.setQuestionId(q3ch2);
        a3q3ch2.setQuestionId(q3ch2);
        a4q3ch2.setQuestionId(q3ch2);
        a1q3ch2.setAnswer("Alkanes");
        a2q3ch2.setAnswer("Alkines");
        a3q3ch2.setAnswer("Alkenes");
        a4q3ch2.setAnswer("Alkynes");
        answerDao.createOrUpdate(a1q3ch2);
        answerDao.createOrUpdate(a2q3ch2);
        answerDao.createOrUpdate(a3q3ch2);
        answerDao.createOrUpdate(a4q3ch2);

        Question q4ch2 = new Question();
        q4ch2.setQuestion("Which compound belongs to alkanes?");
        q4ch2.setTestId(chT1);
        questionDao.createOrUpdate(q4ch2);
        Answer a1q4ch2 = new Answer();
        Answer a2q4ch2 = new Answer();
        Answer a3q4ch2 = new Answer();
        Answer a4q4ch2 = new Answer();
        a1q4ch2.setCorrect(false);
        a2q4ch2.setCorrect(false);
        a3q4ch2.setCorrect(true);
        a4q4ch2.setCorrect(false);
        a1q4ch2.setQuestionId(q4ch2);
        a2q4ch2.setQuestionId(q4ch2);
        a3q4ch2.setQuestionId(q4ch2);
        a4q4ch2.setQuestionId(q4ch2);
        a1q4ch2.setAnswer("Butene");
        a2q4ch2.setAnswer("Propyne");
        a3q4ch2.setAnswer("Ethane");
        a4q4ch2.setAnswer("Propylene");
        answerDao.createOrUpdate(a1q4ch2);
        answerDao.createOrUpdate(a2q4ch2);
        answerDao.createOrUpdate(a3q4ch2);
        answerDao.createOrUpdate(a4q4ch2);

        Question q5ch2 = new Question();
        q5ch2.setQuestion("Which one is the molecular formula of hexane?");
        q5ch2.setTestId(chT1);
        questionDao.createOrUpdate(q5ch2);
        Answer a1q5ch2 = new Answer();
        Answer a2q5ch2 = new Answer();
        Answer a3q5ch2 = new Answer();
        Answer a4q5ch2 = new Answer();
        a1q5ch2.setCorrect(false);
        a2q5ch2.setCorrect(false);
        a3q5ch2.setCorrect(false);
        a4q5ch2.setCorrect(true);
        a1q5ch2.setQuestionId(q5ch2);
        a2q5ch2.setQuestionId(q5ch2);
        a3q5ch2.setQuestionId(q5ch2);
        a4q5ch2.setQuestionId(q5ch2);
        a1q5ch2.setAnswer("C2H2");
        a2q5ch2.setAnswer("C6H12");
        a3q5ch2.setAnswer("CH4");
        a4q5ch2.setAnswer("C6H14");
        answerDao.createOrUpdate(a1q5ch2);
        answerDao.createOrUpdate(a2q5ch2);
        answerDao.createOrUpdate(a3q5ch2);
        answerDao.createOrUpdate(a4q5ch2);




        Test chT3 = new Test();
        chT3.setCategoryId(ch);
        chT3.setName("Elements");
        testDao.createOrUpdate(chT3);

        Question q1ch3 = new Question();
        q1ch3.setQuestion("Os is the symbol of element named:");
        q1ch3.setTestId(chT3);
        questionDao.createOrUpdate(q1ch3);
        Answer a1q1ch3 = new Answer();
        Answer a2q1ch3 = new Answer();
        Answer a3q1ch3 = new Answer();
        Answer a4q1ch3 = new Answer();
        a1q1ch3.setCorrect(true);
        a2q1ch3.setCorrect(false);
        a3q1ch3.setCorrect(false);
        a4q1ch3.setCorrect(false);
        a1q1ch3.setQuestionId(q1ch3);
        a2q1ch3.setQuestionId(q1ch3);
        a3q1ch3.setQuestionId(q1ch3);
        a4q1ch3.setQuestionId(q1ch3);
        a1q1ch3.setAnswer("Osmium");
        a2q1ch3.setAnswer("Osmundium");
        a3q1ch3.setAnswer("Osium");
        a4q1ch3.setAnswer("Sodium");
        answerDao.createOrUpdate(a1q1ch3);
        answerDao.createOrUpdate(a2q1ch3);
        answerDao.createOrUpdate(a3q1ch3);
        answerDao.createOrUpdate(a4q1ch3);

        Question q2ch3 = new Question();
        q2ch3.setQuestion("Th is the symbol of element named:");
        q2ch3.setTestId(chT3);
        questionDao.createOrUpdate(q2ch3);
        Answer a1q2ch3 = new Answer();
        Answer a2q2ch3 = new Answer();
        Answer a3q2ch3 = new Answer();
        Answer a4q2ch3 = new Answer();
        a1q2ch3.setCorrect(false);
        a2q2ch3.setCorrect(false);
        a3q2ch3.setCorrect(true);
        a4q2ch3.setCorrect(false);
        a1q2ch3.setQuestionId(q2ch3);
        a2q2ch3.setQuestionId(q2ch3);
        a3q2ch3.setQuestionId(q2ch3);
        a4q2ch3.setQuestionId(q2ch3);
        a1q2ch3.setAnswer("Thantalium");
        a2q2ch3.setAnswer("Tungsten");
        a3q2ch3.setAnswer("Thorium");
        a4q2ch3.setAnswer("Thormium");
        answerDao.createOrUpdate(a1q2ch3);
        answerDao.createOrUpdate(a2q2ch3);
        answerDao.createOrUpdate(a3q2ch3);
        answerDao.createOrUpdate(a4q2ch3);
        
        Question q3ch3 = new Question();
        q3ch3.setQuestion("Which element does not belong to the noble gases?");
        q3ch3.setTestId(chT1);
        questionDao.createOrUpdate(q3ch3);
        Answer a1q3ch3 = new Answer();
        Answer a2q3ch3 = new Answer();
        Answer a3q3ch3 = new Answer();
        Answer a4q3ch3 = new Answer();
        a1q3ch3.setCorrect(false);
        a2q3ch3.setCorrect(false);
        a3q3ch3.setCorrect(false);
        a4q3ch3.setCorrect(true);
        a1q3ch3.setQuestionId(q3ch3);
        a2q3ch3.setQuestionId(q3ch3);
        a3q3ch3.setQuestionId(q3ch3);
        a4q3ch3.setQuestionId(q3ch3);
        a1q3ch3.setAnswer("Xenon");
        a2q3ch3.setAnswer("Radon");
        a3q3ch3.setAnswer("Argon");
        a4q3ch3.setAnswer("Chlorine");
        answerDao.createOrUpdate(a1q3ch3);
        answerDao.createOrUpdate(a2q3ch3);
        answerDao.createOrUpdate(a3q3ch3);
        answerDao.createOrUpdate(a4q3ch3);

        Question q5ch3 = new Question();
        q5ch3.setQuestion("Which one is the symbol of silver");
        q5ch3.setTestId(chT1);
        questionDao.createOrUpdate(q5ch3);
        Answer a1q5ch3 = new Answer();
        Answer a2q5ch3 = new Answer();
        Answer a3q5ch3 = new Answer();
        Answer a4q5ch3 = new Answer();
        a1q5ch3.setCorrect(false);
        a2q5ch3.setCorrect(true);
        a3q5ch3.setCorrect(false);
        a4q5ch3.setCorrect(false);
        a1q5ch3.setQuestionId(q5ch3);
        a2q5ch3.setQuestionId(q5ch3);
        a3q5ch3.setQuestionId(q5ch3);
        a4q5ch3.setQuestionId(q5ch3);
        a1q5ch3.setAnswer("Sc");
        a2q5ch3.setAnswer("Aq");
        a3q5ch3.setAnswer("Pd");
        a4q5ch3.setAnswer("Sn");
        answerDao.createOrUpdate(a1q5ch3);
        answerDao.createOrUpdate(a2q5ch3);
        answerDao.createOrUpdate(a3q5ch3);
        answerDao.createOrUpdate(a4q5ch3);
        
        

        Result rch1 = new Result();
        rch1.setDate(new Date());
        rch1.setScore(3);
        rch1.setUserId(u1);
        rch1.setTestId(chT1);
        resultDao.createOrUpdate(rch1);

        Result rch2 = new Result();
        rch2.setDate(new Date());
        rch2.setScore(4);
        rch2.setUserId(u2);
        rch2.setTestId(chT1);
        resultDao.createOrUpdate(rch2);

        Result rch3 = new Result();
        rch3.setDate(new Date());
        rch3.setScore(5);
        rch3.setUserId(u3);
        rch3.setTestId(chT1);
        resultDao.createOrUpdate(rch3);

        Result rch4 = new Result();
        rch4.setDate(new Date());
        rch4.setScore(5);
        rch4.setUserId(u4);
        rch4.setTestId(chT1);
        resultDao.createOrUpdate(rch4);

        Result rch5 = new Result();
        rch5.setDate(new Date());
        rch5.setScore(2);
        rch5.setUserId(u5);
        rch5.setTestId(chT1);
        resultDao.createOrUpdate(rch5);

        Result rch6 = new Result();
        rch6.setDate(new Date());
        rch6.setScore(5);
        rch6.setUserId(u1);
        rch6.setTestId(chT2);
        resultDao.createOrUpdate(rch6);

        Result rch7 = new Result();
        rch7.setDate(new Date());
        rch7.setScore(1);
        rch7.setUserId(u2);
        rch7.setTestId(chT2);
        resultDao.createOrUpdate(rch7);

        Result rch8 = new Result();
        rch8.setDate(new Date());
        rch8.setScore(5);
        rch8.setUserId(u3);
        rch8.setTestId(chT2);
        resultDao.createOrUpdate(rch8);

        Result rch9 = new Result();
        rch9.setDate(new Date());
        rch9.setScore(5);
        rch9.setUserId(u4);
        rch9.setTestId(chT2);
        resultDao.createOrUpdate(rch9);

        Result rch10 = new Result();
        rch10.setDate(new Date());
        rch10.setScore(4);
        rch10.setUserId(u5);
        rch10.setTestId(chT2);
        resultDao.createOrUpdate(rch10);

        Result rch11 = new Result();
        rch11.setDate(new Date());
        rch11.setScore(5);
        rch11.setUserId(u1);
        rch11.setTestId(chT3);
        resultDao.createOrUpdate(rch11);

        Result rch12 = new Result();
        rch12.setDate(new Date());
        rch12.setScore(4);
        rch12.setUserId(u2);
        rch12.setTestId(chT3);
        resultDao.createOrUpdate(rch12);

        Result rch13 = new Result();
        rch13.setDate(new Date());
        rch13.setScore(5);
        rch13.setUserId(u3);
        rch13.setTestId(chT3);
        resultDao.createOrUpdate(rch13);

        Result rch14 = new Result();
        rch14.setDate(new Date());
        rch14.setScore(5);
        rch14.setUserId(u4);
        rch14.setTestId(chT3);
        resultDao.createOrUpdate(rch14);

        Result rch15 = new Result();
        rch15.setDate(new Date());
        rch15.setScore(3);
        rch15.setUserId(u5);
        rch15.setTestId(chT3);
        resultDao.createOrUpdate(rch15);

        Category l = new Category();
        l.setName("Literature");
        categoryDao.createOrUpdate(l);

        Test lT1 = new Test();
        lT1.setCategoryId(l);
        lT1.setName("Famous authors");
        testDao.createOrUpdate(lT1);

        Question q1l1 = new Question();
        q1l1.setQuestion("\"Frankenstein\" was written by:");
        q1l1.setTestId(chT1);
        questionDao.createOrUpdate(q1l1);
        Answer a1q1l1 = new Answer();
        Answer a2q1l1 = new Answer();
        Answer a3q1l1 = new Answer();
        Answer a4q1l1 = new Answer();
        a1q1l1.setCorrect(true);
        a2q1l1.setCorrect(false);
        a3q1l1.setCorrect(false);
        a4q1l1.setCorrect(false);
        a1q1l1.setQuestionId(q1l1);
        a2q1l1.setQuestionId(q1l1);
        a3q1l1.setQuestionId(q1l1);
        a4q1l1.setQuestionId(q1l1);
        a1q1l1.setAnswer("Mary Shelley");
        a2q1l1.setAnswer("Jane Austen");
        a3q1l1.setAnswer("Mark Twain");
        a4q1l1.setAnswer("Ernest Hemingway");
        answerDao.createOrUpdate(a1q1l1);
        answerDao.createOrUpdate(a2q1l1);
        answerDao.createOrUpdate(a3q1l1);
        answerDao.createOrUpdate(a4q1l1);

        Question q2l1 = new Question();
        q2l1.setQuestion("Which book wasn't written by William Shakespeare?");
        q2l1.setTestId(chT1);
        questionDao.createOrUpdate(q2l1);
        Answer a1q2l1 = new Answer();
        Answer a2q2l1 = new Answer();
        Answer a3q2l1 = new Answer();
        Answer a4q2l1 = new Answer();
        a1q2l1.setCorrect(false);
        a2q2l1.setCorrect(true);
        a3q2l1.setCorrect(false);
        a4q2l1.setCorrect(false);
        a1q2l1.setQuestionId(q2l1);
        a2q2l1.setQuestionId(q2l1);
        a3q2l1.setQuestionId(q2l1);
        a4q2l1.setQuestionId(q2l1);
        a1q2l1.setAnswer("\"Macbeth\"");
        a2q2l1.setAnswer("\"Lolita\"");
        a3q2l1.setAnswer("\"King Lear\"");
        a4q2l1.setAnswer("\"Hamlet\"");
        answerDao.createOrUpdate(a1q2l1);
        answerDao.createOrUpdate(a2q2l1);
        answerDao.createOrUpdate(a3q2l1);
        answerDao.createOrUpdate(a4q2l1);

        Question q3l1 = new Question();
        q3l1.setQuestion("\"The Odyssey\" was written by:");
        q3l1.setTestId(chT1);
        questionDao.createOrUpdate(q3l1);
        Answer a1q3l1 = new Answer();
        Answer a2q3l1 = new Answer();
        Answer a3q3l1 = new Answer();
        Answer a4q3l1 = new Answer();
        a1q3l1.setCorrect(true);
        a2q3l1.setCorrect(false);
        a3q3l1.setCorrect(false);
        a4q3l1.setCorrect(false);
        a1q3l1.setQuestionId(q3l1);
        a2q3l1.setQuestionId(q3l1);
        a3q3l1.setQuestionId(q3l1);
        a4q3l1.setQuestionId(q3l1);
        a1q3l1.setAnswer("Homer");
        a2q3l1.setAnswer("Herman Melville");
        a3q3l1.setAnswer("Virgil");
        a4q3l1.setAnswer("Plato");
        answerDao.createOrUpdate(a1q3l1);
        answerDao.createOrUpdate(a2q3l1);
        answerDao.createOrUpdate(a3q3l1);
        answerDao.createOrUpdate(a4q3l1);

        Question q4l1 = new Question();
        q4l1.setQuestion("Who wrote \"Don Quixote\"?");
        q4l1.setTestId(chT1);
        questionDao.createOrUpdate(q4l1);
        Answer a1q4l1 = new Answer();
        Answer a2q4l1 = new Answer();
        Answer a3q4l1 = new Answer();
        Answer a4q4l1 = new Answer();
        a1q4l1.setCorrect(false);
        a2q4l1.setCorrect(false);
        a3q4l1.setCorrect(true);
        a4q4l1.setCorrect(false);
        a1q4l1.setQuestionId(q4l1);
        a2q4l1.setQuestionId(q4l1);
        a3q4l1.setQuestionId(q4l1);
        a4q4l1.setQuestionId(q4l1);
        a1q4l1.setAnswer("William Shakespeare");
        a2q4l1.setAnswer("James Joyce");
        a3q4l1.setAnswer("Miguel de Cervantes");
        a4q4l1.setAnswer("Leo Tolstoy");
        answerDao.createOrUpdate(a1q4l1);
        answerDao.createOrUpdate(a2q4l1);
        answerDao.createOrUpdate(a3q4l1);
        answerDao.createOrUpdate(a4q4l1);

        Question q5l1 = new Question();
        q5l1.setQuestion("\"Pride and Prejudice\" was written by:");
        q5l1.setTestId(chT1);
        questionDao.createOrUpdate(q5l1);
        Answer a1q5l1 = new Answer();
        Answer a2q5l1 = new Answer();
        Answer a3q5l1 = new Answer();
        Answer a4q5l1 = new Answer();
        a1q5l1.setCorrect(false);
        a2q5l1.setCorrect(false);
        a3q5l1.setCorrect(false);
        a4q5l1.setCorrect(true);
        a1q5l1.setQuestionId(q5l1);
        a2q5l1.setQuestionId(q5l1);
        a3q5l1.setQuestionId(q5l1);
        a4q5l1.setQuestionId(q5l1);
        a1q5l1.setAnswer("Lewis Carroll");
        a2q5l1.setAnswer("Leo Tolstoy");
        a3q5l1.setAnswer("J. D. Salinger");
        a4q5l1.setAnswer("Jane Austen");
        answerDao.createOrUpdate(a1q5l1);
        answerDao.createOrUpdate(a2q5l1);
        answerDao.createOrUpdate(a3q5l1);
        answerDao.createOrUpdate(a4q5l1);


        Result rl1 = new Result();
        rl1.setDate(new Date());
        rl1.setScore(3);
        rl1.setUserId(u1);
        rl1.setTestId(lT1);
        resultDao.createOrUpdate(rl1);

        Result rl2 = new Result();
        rl2.setDate(new Date());
        rl2.setScore(4);
        rl2.setUserId(u2);
        rl2.setTestId(lT1);
        resultDao.createOrUpdate(rl2);

        Result rl3 = new Result();
        rl3.setDate(new Date());
        rl3.setScore(5);
        rl3.setUserId(u3);
        rl3.setTestId(lT1);
        resultDao.createOrUpdate(rl3);

        Result rl4 = new Result();
        rl4.setDate(new Date());
        rl4.setScore(5);
        rl4.setUserId(u4);
        rl4.setTestId(lT1);
        resultDao.createOrUpdate(rl4);

        Result rl5 = new Result();
        rl5.setDate(new Date());
        rl5.setScore(5);
        rl5.setUserId(u5);
        rl5.setTestId(lT1);
        resultDao.createOrUpdate(rl5);
    }


}
