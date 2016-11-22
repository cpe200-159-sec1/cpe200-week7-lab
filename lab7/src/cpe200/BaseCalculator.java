package cpe200;
import java.math.BigDecimal;
import java.math.RoundingMode;
public abstract class BaseCalculator {
        protected IOperand firstOperand;
        protected IOperand secondOperand;
        public BaseCalculator() {
        }
        public String getFirstOperand() {
                return firstOperand.getOperand();
        }
        public void setFirstOperand(IOperand operand) {
            firstOperand = operand;
        }
        public String getSecondOperand() {
                return secondOperand.getOperand();
        }
        public void setSecondOperand(IOperand operand) {
                secondOperand = operand;
        }
        public abstract String add();
        public abstract String subtract();
         public abstract String multiply();
        /* This method should throw an exception when divide by zero */
        public abstract String division();
        public abstract String power();
 }