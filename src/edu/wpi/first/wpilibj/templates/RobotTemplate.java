/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;


public class RobotTemplate extends IterativeRobot {

    private Joystick joystick;
    private Compressor compressor;
    private Solenoid sol;
    private boolean released;
    private boolean retracted; 
    int cRioCartridgeSlot;
    //int pneumaticChannel;
    int pressureSwitchChannel; 
    int relayChannel;

    public void robotInit()
    {
        cRioCartridgeSlot = 2;
        //pneumaticChannel = 1;
        pressureSwitchChannel = 14;
        relayChannel = 8;

        released = true;
        retracted = false;

        joystick = new Joystick(1);
        compressor = new Compressor(pressureSwitchChannel, relayChannel); //find exact parameters
        sol = new Solenoid(cRioCartridgeSlot, 8); //find exact parameters

        compressor.start();
        sol.startLiveWindowMode();
        //ompressor.startLiveWindowMode();
    }

    public void autonomousPeriodic() {

    }

    public void teleopPeriodic() 
    {
        if(joystick.getRawButton(5))
        {
            released();
        }

        if(joystick.getRawButton(3))
        {
            retracted();
        }
    }

    public void disabledInit()
    {
        System.out.println("That test bed is ready to rock and roll!");
    }

    public void testPeriodic() {
    
    }

    public void retracted()
    {
        sol.set(retracted);
    }

    public void released()
    {
        sol.set(released);
    }
    
}
