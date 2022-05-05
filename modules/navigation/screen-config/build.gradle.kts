import com.project.picpicker.Dependency
import com.project.picpicker.Modules.bottomNavigation
import com.project.picpicker.Modules.toolbar
import com.project.picpicker.dependency.helper.addDep
import com.project.picpicker.dependency.helper.module
import com.project.picpicker.dependency.helper.plus
import com.project.picpicker.plugins.config.module

module(
    appDependency = addDep(
        *Dependency.jetpackComposeUi,
    ) + addDep(
        module(bottomNavigation),
        module(toolbar),
    )
)