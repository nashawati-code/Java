import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class LexicalAnalyzer {

        CharacterClasses charClass;
        StringBuilder lexeme = new StringBuilder();
        public StringBuilder html = new StringBuilder();
        char nextChar;
        Tokens nextToken;
        CharacterIterator Iterator;

        enum CharacterClasses {
            LETTER,
            DIGIT,
            UNKNOWN,
            EOF
        }
        enum Tokens {

            INT_LIT,
            IDENT,
            ASSIGN_OP,
            ADD_OP,
            SUB_OP,
            MULT_OP,
            DIV_OP,
            LEFT_PAREN,
            RIGHT_PAREN,
            EOF
        }

        void addChar() { // addChar - a function to add nextChar to lexeme 
            if (lexeme.length()<= 98)
            {
                lexeme.append(nextChar);
            }
            else
            	System.out.println("Error - lexeme is too long \n");
        }

        Tokens lookup(char ch) //lookup - a function to lookup operators and parentheses and return the token
        {
            switch (ch)
            {
                case '(':
                    addChar();
                    nextToken = Tokens.LEFT_PAREN;
                    break;
                case ')':
                    addChar();
                    nextToken = Tokens.RIGHT_PAREN;
                    break;
                case '+':
                    addChar();
                    nextToken = Tokens.ADD_OP;
                    break;
                case '-':
                    addChar();
                    nextToken = Tokens.SUB_OP;
                    break;
                case '*':
                    addChar();
                    nextToken = Tokens.MULT_OP;
                    break;
                case '/':
                    addChar();
                    nextToken = Tokens.DIV_OP;
                    break;
                default:
                    addChar();
                    nextToken = Tokens.EOF;
                    break;
            }
            return nextToken;
        }

        void getChar() //getChar - a function to get the next character of input and determine its character class
        {
        	char c = Iterator.current();
        	Iterator.next();
            if (c!=CharacterIterator.DONE)
            {
                nextChar = c;
                if (Character.isLetter(nextChar))
                    charClass = CharacterClasses.LETTER;
                else if (Character.isDigit(nextChar))
                    charClass = CharacterClasses.DIGIT;
                else
                    charClass = CharacterClasses.UNKNOWN;
            }
            else
                charClass = CharacterClasses.EOF;
        }

        public LexicalAnalyzer(String Statement)
        {
            Iterator = new StringCharacterIterator(Statement);
            getChar();
            do
            {
                lex();
            } while (nextToken != Tokens.EOF);
        }

        void getNonBlank()
        {
            while (Character.isWhitespace(nextChar))
                getChar();
        }

        Tokens lex() //lex - a simple lexical analyzer for arithmetic expressions
        {
            getNonBlank();
            switch (charClass)
            {
                case LETTER:
                /* Parse identifiers */
                    addChar();
                    getChar();
                    while (charClass == CharacterClasses.LETTER || charClass == CharacterClasses.DIGIT)
                    {
                        addChar();
                        getChar();
                    }
                    nextToken = Tokens.IDENT;
                    break;
                case DIGIT:
                /* Parse integer literals */
                    addChar();
                    getChar();
                    while (charClass == CharacterClasses.DIGIT)
                    {
                        addChar();
                        getChar();
                    }
                    nextToken = Tokens.INT_LIT;
                    break;
                case UNKNOWN:
                    /* Parentheses and operators */
                    lookup(nextChar);
                    getChar();
                    break;
                case EOF:
                    nextToken = Tokens.EOF;
                    lexeme.append("\n");
                    break;
                default:
                    break;
            }
            print();
            lexeme = new StringBuilder();
            return nextToken;
        }
        void print()
        {
        	String c = "regular";
            switch (nextToken)
            {
                case INT_LIT:
                	c = "color:red;";
                    break;
                case IDENT:
                	c = "color:purple;font-weight:bold;";
                    break;
                case ASSIGN_OP:
                case ADD_OP:
                case SUB_OP:
                case MULT_OP:
                case DIV_OP:
                    c="color:green;font-size:smaller;";
                    break;
                case LEFT_PAREN:
                case RIGHT_PAREN:
                    c="color:blue;font-size:14px;";
                    break;
                case EOF:
                    break;
                default:
                    break;
            }
            String tag = String.format("<span style='%s'>%s</span>\n",c,lexeme);
            System.out.print(tag);
            html.append(tag);
        }
    }