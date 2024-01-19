package com.example.courses

import DataSource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.model.Course
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseApp()
                }
            }
        }
    }
}

@Composable
fun CourseApp(){
    CourseGrid(courseList = DataSource.courses)
}

@Composable
fun CourseGrid(courseList:List<Course>,modifier: Modifier=Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 8.dp)
    ){
        items(courseList){ course ->
            CourseCard(course = course)
        }
    }
}

@Composable
fun CourseCard(course: Course,modifier: Modifier=Modifier){
    Card(modifier=modifier) {
        Row {
            Image(
                painter = painterResource(id = course.imageResourceId),
                contentDescription = stringResource(id = course.courseNameId),
                modifier=Modifier.size(68.dp)
            )
            Column(modifier=modifier.padding(top=16.dp, start = 16.dp,end=16.dp)) {
                Text(text = stringResource(id =course.courseNameId),style = MaterialTheme.typography.bodyMedium)
                Row(modifier=modifier.padding(top=8.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.ic_grain), contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "${course.quantity}",style = MaterialTheme.typography.labelMedium)
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CourseCardPreview() {
    CoursesTheme {
//        CourseCard(Course(R.string.architecture, 321, R.drawable.architecture))
        CourseApp()
    }
}