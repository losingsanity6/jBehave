import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;
import stepdefs.GoogleSteps;
import stepdefs.Hooks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class JBehaveBase extends JUnitStories {
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(StoryReporterBuilder.Format.HTML, StoryReporterBuilder.Format.CONSOLE)
                        .withRelativeDirectory("jbehave-report"));

    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        ArrayList<Steps> stepFileList = new ArrayList<>();
        stepFileList.add(new GoogleSteps());
        stepFileList.add( new Hooks());
        return new InstanceStepsFactory(configuration(), stepFileList);
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().
                findPaths(codeLocationFromClass(this.getClass()).getFile(),
                        Arrays.asList("**/*.story"),
                        Arrays.asList(""));

    }


}
