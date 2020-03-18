   //+++++++++++++++++//
  //  Aya Nashawati  //
 //    201902869    //
//+++++++++++++++++//

//============================================================================================//

interface Expression {
	
	//---------------------------------------------------------//
	
	//Add an instance method printExpression to Expression and its subtypes that prints the Boolean expression.
    public void printExpression();
    public void Accept(ExpressionVisitor visitor);
    
    //---------------------------------------------------------//
}

//============================================================================================//

//Variable which stores a string holding the name of a Boolean variable 

class Variable implements Expression {
    
	private String name;
    public Variable(String n) { name = n; }
    public String getName() { return name; }
    
    //---------------------------------------------------------//
    
    public void printExpression() 
    { 
    	System.out.print(this.name); 
    }
    
    public void Accept(ExpressionVisitor visitor) 
    { 
    	visitor.Visit(this); 
    }
    
    //---------------------------------------------------------//
}

//============================================================================================//

//Negate which stores a reference to an expression that is an operand to a negation (!) operation  

class Negate implements Expression {
    
	private Expression operand;
    public Negate(Expression op) { operand = op; }
    public Expression getOperand() { return operand; }
    
    //---------------------------------------------------------//
    
    public void printExpression() 
    { 
        System.out.print("!"); 
        
        operand.printExpression();
    }
    
    public void Accept(ExpressionVisitor visitor) 
    { 
    	visitor.Visit(this); 
    }
    
    //---------------------------------------------------------//
}

//============================================================================================//

//And which stores references to two expressions that are operands to an and  (&&) operation 

class And implements Expression {
    
	private Expression operand1;
    private Expression operand2;
    public And(Expression op1, Expression op2) { operand1 = op1; operand2 = op2; }
    public Expression getOperand1() { return operand1; }
    public Expression getOperand2() { return operand2; }
    
    //---------------------------------------------------------//
    
    public void printExpression() 
    { 
        operand1.printExpression();
        
        System.out.print(" && "); 
        
        operand2.printExpression();
    }
    
    public void Accept(ExpressionVisitor visitor) 
    { 
    	visitor.Visit(this); 
    }
    
    //---------------------------------------------------------//
}

//============================================================================================//

//A class Or which stores references to two expressions that are operands to an or (||) operation
class Or implements Expression {
    private Expression operand1;
    private Expression operand2;
    public Or(Expression op1, Expression op2) { operand1 = op1; operand2 = op2; }
    public Expression getOperand1() { return operand1; }
    public Expression getOperand2() { return operand2; }
    
    //---------------------------------------------------------//
    
    public void printExpression() 
    { 
        operand1.printExpression();
        
        System.out.print(" || "); 
        
        operand2.printExpression();
    }
    
    public void Accept(ExpressionVisitor visitor) 
    { 
    	visitor.Visit(this); 
    }
 
    //---------------------------------------------------------//
}

//============================================================================================//

//---------------------------------------------------------//

//Create a visitor ExpressionVisitor that visits Expression and its subtypes. 
//You may modify Expression and its subtypes to accept ExpressionVisitor. 

class ExpressionVisitor 
{
    public void Traverse(Expression operand) 
    {
    	operand.Accept(this); 
    }
    
    public void Visit(Variable visit_variable) 
    { 
    	
    }
    public void Visit(Negate visit_negate) 
    { 
    	
    }
    public void Visit(And visit_and) 
    { 
    	
    }
    public void Visit(Or visit_or) 
    {
    	
    }
}

//---------------------------------------------------------//

//============================================================================================//

//---------------------------------------------------------//

//Use ExpressionVisitor to define a custom visitor called ExpressionPrinter that prints the Boolean expression. 
//You are not allowed to use the printExpression instance method you defined previously. 

class ExpressionPrinter extends ExpressionVisitor {
    public void Visit(Variable v) { System.out.print(v.getName()); }
    public void Visit(Negate n) { 
        System.out.print("!"); 
        n.getOperand().Accept(this);;
    }
    public void Visit(And a) { 
        a.getOperand1().Accept(this);;
        System.out.print(" && "); 
        a.getOperand2().Accept(this);;
    }
    public void Visit(Or o) { 
        o.getOperand1().Accept(this);;
        System.out.print(" || "); 
        o.getOperand2().Accept(this);;
    }
}

//---------------------------------------------------------//

//============================================================================================//

public class Assignment3B {

    public static void main(String[] args) {
        
    	//---------------------------------------------------------//
    	
    	// Create myTree
    	//In main, create a value myTree of type Expression that stores an expression tree for the following expression: x && !y || !x && y
        
    	Expression myTree = new Or(
        							new And(new Variable("x"), new Negate(new Variable("y"))) , 
        							new And(new Negate(new Variable("x") ), new Variable("y"))
        						  );
        //---------------------------------------------------------//
        // Dispatch method to print myTree
        
        myTree.printExpression();
        System.out.print("\n");
        // Use visitor to print myTree
        ExpressionPrinter printer = new ExpressionPrinter();
        printer.Traverse(myTree);
        System.out.print("\n");
    }

}
//============================================================================================//