package transaction_reader.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class FileConfig {
    private final Set<String> availableExtensions;

    @JsonCreator
    public FileConfig(@JsonProperty("availableExtensions") Set<String> availableExtensions) {
        this.availableExtensions = availableExtensions;
    }

    public Set<String> getAvailableExtensions(){
        return availableExtensions;
    }
}
