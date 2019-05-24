package model.strategy;

public class FileSystemProvider {
	private IFileSystemStrategy authenticationStrategy;              
    
    public void setAuthenticationStrategy(IFileSystemStrategy strategy){           
        this.authenticationStrategy = strategy;       
    }
    
    public TextRepresentation loadFile() {
    	if(authenticationStrategy==null){               
            throw new RuntimeException("Estrategia no definida");           
        }           
        
        return authenticationStrategy.loadFile();
    }
    
	public void saveFile(TextRepresentation pText) {
		if(authenticationStrategy==null){               
            throw new RuntimeException("Estrategia no definida");           
        }           
        
        authenticationStrategy.saveFile(pText);
	}
	
	public void setFile(String pPath) {
		if(authenticationStrategy==null){               
            throw new RuntimeException("Estrategia no definida");           
        }           
        
        authenticationStrategy.setFile(pPath);
	};  
}
