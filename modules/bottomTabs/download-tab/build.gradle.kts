import com.project.picpicker.Dependency.composePreview
import com.project.picpicker.Dependency.hilt
import com.project.picpicker.Dependency.hiltNavigation
import com.project.picpicker.Dependency.jetpackComposeUi
import com.project.picpicker.Modules.bottomNavigation
import com.project.picpicker.Modules.commonResources
import com.project.picpicker.Modules.navigationApi
import com.project.picpicker.dependency.helper.addDep
import com.project.picpicker.dependency.helper.module
import com.project.picpicker.dependency.helper.plus
import com.project.picpicker.plugins.config.module

module(
    appDependency = addDep(
        hiltNavigation,
        *jetpackComposeUi,
        *hilt,
        *composePreview,
    ) + addDep(
        module(bottomNavigation),
        module(navigationApi),
        module(commonResources),
    )
)