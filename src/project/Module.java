package project;

public class Module {
    String ModuleSeries;
    String ModuleHealth;
    String ModuleCurrent;
   
    

    public Module(String moduleseries, String modulehealth, String modulecurrent) {
        this.ModuleSeries = moduleseries;
        this.ModuleHealth = modulehealth;
        this.ModuleCurrent = modulecurrent;
        
    }

    public String getModuleSeries() {
        return ModuleSeries;
    }

    public void setModuleSeries(String moduleseries) {
        this.ModuleSeries = moduleseries;
    }

    public String getModuleHealth() {
        return ModuleHealth;
    }

    public void setModuleHealth(String modulehealth) {
        this.ModuleHealth = modulehealth;
    }

    public String getModuleCurrent() {
        return ModuleCurrent;
    }

    public void setModuleCurrent(String modulecurrent) {
        this.ModuleCurrent = modulecurrent;
    }

  
    

    
    
       
}