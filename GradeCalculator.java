/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grades;

/*
    Created by: Seth A. Griffin
    Last edited: 05/24/2018
    The purpose of this class is to hold weights and grades
    for a given school course and calculate your grade.
*/
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
public class GradeCalculator 
{
	DecimalFormat df = new DecimalFormat("###.00");
        
        // 0 = attendance, 1 = homework, 2 = quiz, 3 = exam, 4 = project
        private Double[] _weights = new Double[5];
        private Double[] _earnedPoints = new Double[5];
        private Double[] _totalPoints = new Double[5];
        
	// Constructor
	public GradeCalculator(){}
        
        public void SetWeights(Double[] theWeights)
        {
            for(int x = 0; x < theWeights.length; x++)
            {
                _weights[x] = theWeights[x];
            }
        }
        
        public void SetGrades(Double[] theEarnedPoints, Double[] theTotalPoints)
        {
            for(int x = 0; x < theEarnedPoints.length; x++)
            {
                if(theTotalPoints[x] >= theEarnedPoints[x])
                {
                    _earnedPoints[x] = theEarnedPoints[x];
                    _totalPoints[x] = theTotalPoints[x];
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please enter a value for earned points that is less than or "
                            + "equal to its total possible points.");
                }
            }
        }
        
        public String CalculateGrade()
        {
            Double totalEarnedPoints = 0.0, totalPossiblePoints = 0.0, finalGradeValue = 0.0;
            String attendanceGrade = "", homeworkGrade = "", quizGrade = "", examGrade = "", projectGrade = "", finalGradeOutput = "";
            
            for(int x = 0; x < _earnedPoints.length; x++)
            {
                switch(x)
                {
                    case 0: 
                    { 
                        if(_weights[x] != 0)
                        {
                            attendanceGrade = "Attendance Grade: " + df.format((_earnedPoints[x] / _totalPoints[x]) * 100) + "% | Weight: " + (_weights[x] * 100) + "%\n";
                            //FInal score is off when using this method, seems to be adding an additional 
                            finalGradeValue = finalGradeValue + ((_earnedPoints[x] / _totalPoints[x]) * _weights[x]);
                        }
                        else{ attendanceGrade = ""; }
                    } break;
                    case 1: 
                    { 
                        if(_weights[x] != 0)
                        {
                            homeworkGrade = "Homework Grade: " + df.format((_earnedPoints[x] / _totalPoints[x]) * 100) + "% | Weight: " + (_weights[x] * 100) + "%\n";
                            finalGradeValue = finalGradeValue + ((_earnedPoints[x] / _totalPoints[x]) * _weights[x]);
                        }
                        else{ homeworkGrade = ""; }
                    } break;
                    case 2: 
                    { 
                        if(_weights[x] != 0)
                        {
                            quizGrade = "Quiz Grade: " + df.format((_earnedPoints[x] / _totalPoints[x]) * 100) + "% | Weight: " + (_weights[x] * 100) + "%\n";
                            finalGradeValue = finalGradeValue + ((_earnedPoints[x] / _totalPoints[x]) * _weights[x]);
                        }
                        else { quizGrade = ""; }
                    } break;
                    case 3: 
                    { 
                        if(_weights[x] != 0)
                        {
                            examGrade = "Exam Grade: " + df.format((_earnedPoints[x] / _totalPoints[x]) * 100) + "% | Weight: " + (_weights[x] * 100) + "%\n";
                            finalGradeValue = finalGradeValue + ((_earnedPoints[x] / _totalPoints[x]) * _weights[x]);
                        }
                        else { examGrade = ""; }
                    } break;
                    case 4: 
                    { 
                        if(_weights[x] != 0)
                        {
                            projectGrade = "Project Grade: " + df.format((_earnedPoints[x] / _totalPoints[x]) * 100) + "% | Weight: " + (_weights[x] * 100) + "%\n";
                            finalGradeValue = finalGradeValue + ((_earnedPoints[x] / _totalPoints[x]) * _weights[x]);
                        }
                        else { projectGrade = ""; }
                    }
                }
            }
            finalGradeOutput = "Final Grade: " + df.format(finalGradeValue * 100) + "%";
            String gradesOutput = attendanceGrade +
                                   homeworkGrade +
                                   quizGrade +
                                   examGrade + 
                                   projectGrade +
                                   finalGradeOutput;
            
            return gradesOutput;
        }
        
        public void DisplayGrade()
        {
            JOptionPane.showMessageDialog(null, "Grade Percentages:\n" + this.CalculateGrade());
        }
        
        public double GetAttendanceWeight()
	{
		return this._weights[0];
	}
	
	public double GetHomeworkWeight()
	{
		return this._weights[1];
	}
	
	public double GetQuizWeight()
	{
		return this._weights[2];
	}
	
	public double GetExamWeight()
	{
		return this._weights[3];
	}
	
	public double GetProjectWeight()
	{
		return this._weights[4];
	}
        
        
}
