import {Component, OnInit} from '@angular/core';
import {Comments} from '../../shared/comments';
import {CommentsService} from '../../services/comments.service/comments.service';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.scss']
})
export class CommentsComponent implements OnInit {
  comment: Comments = new Comments();
  user = JSON.parse(localStorage.getItem('userData'));
  comments: Comments[] = [];

  constructor(private commentsService: CommentsService) {
  }

  ngOnInit() {
    this.getComments();

  }

  postComment() {
    this.comment.authorId = this.user.id;
    this.comment.commentRateId = 5;
    this.comment.commentsId = null;
    this.comment.postDate = Date();


    console.log('POSTING COMMENT');
    this.commentsService.postNewComment(this.comment).subscribe(
      resp => {
        var data = resp;
      },

      error => {
        window.alert('Something went wrong, we could not post your comment, please try again!');
      }
    );
  }

  getComments() {
    this.commentsService.getAllComments().subscribe(
      resp => {
        console.log(resp);
        this.comments = resp;
      },
      error => {
        window.alert('something went wrong we are not able to retrieve your comments, try again!');
      }
    );
  }

   doDate() {
    var str = "";

    var days = new Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
    var months = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

    var now = new Date();

    str += "14. Today is: " + days[now.getDay()] + ", " + now.getDate() + " " + months[now.getMonth()] + " " + now.getFullYear() + " " + now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
    document.getElementById("timeInput").innerHTML = str;
  }


}
