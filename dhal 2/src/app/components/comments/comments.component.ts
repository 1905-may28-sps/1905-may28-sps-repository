import {Component, OnInit} from '@angular/core';
import {Comments} from '../../shared/comments';
import {CommentsService} from '../../services/comments.service/comments.service';
import {UsersService} from '../../services/user.service/users.service';
import {User} from '../../shared/model';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.scss']
})
export class CommentsComponent implements OnInit {
  comment: Comments = new Comments();
  user = JSON.parse(localStorage.getItem('userData'));
  comments: Comments[] = [];
  commenterId: number;
  commenter: User;

  constructor(private commentsService: CommentsService,
              private userService: UsersService) {
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
        const data = resp;
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
        console.log(resp[0].authorId);
        this.commenterId = resp[0].authorId;
        this.comments = resp;
        this.getCommenterById(this.commenterId);
      },
      error => {
        window.alert('something went wrong we are not able to retrieve your comments, try again!');
      }
    );
  }

  doDate() {
    var str = '';

    const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August',
      'September', 'October', 'November', 'December'];

    const now = new Date();

    str += '14. Today is: ' + days[now.getDay()] + ', ' + now.getDate() + ' ' + months[now.getMonth()] + ' ' + now.getFullYear()
      + ' ' + now.getHours() + ':' + now.getMinutes() + ':' + now.getSeconds();
    document.getElementById('timeInput').innerHTML = str;
  }

  getCommenterById(commenterId) {
    console.log(commenterId);
    this.userService.getUserById(commenterId).subscribe(
      resp => {
        console.log(resp);
        this.commenter = resp;
      }
    );
  }
}
